package BLL;

import DAL.PhieuNhapHangDAL;
import DTO.PhieuNhapHangDTO;
import DTO.ChiTietPhieuNhapHangDTO;

import DAL.DatabaseHelper;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class PhieuNhapHangBLL {
    private PhieuNhapHangDAL pnhDAL = new PhieuNhapHangDAL();

    public List<PhieuNhapHangDTO> layDanhSachPhieuNhapHang() {
        return pnhDAL.layDanhSachPhieuNhapHang();
    }

    public boolean XuLyThemPNH(PhieuNhapHangDTO pnh, List<ChiTietPhieuNhapHangDTO> danhSachChiTiet) {
        Connection conn = null;
        try {
            conn = DatabaseHelper.getConnection();
            conn.setAutoCommit(false);

            if (!pnhDAL.ThemPNH(pnh, conn)) {
                conn.rollback();
                return false;
            }

            for (ChiTietPhieuNhapHangDTO ct : danhSachChiTiet) {
                if (!pnhDAL.ThemCTPNH(ct, conn)) {
                    conn.rollback();
                    return false;
                }
            }

            double tongTien = pnhDAL.tinhTongTienPhieuNhap(pnh.getMaPNH(), conn);
            pnh.setThanhTien(tongTien);

            if (!pnhDAL.SuaPNH(pnh, conn)) {
                conn.rollback();
                return false;
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                }
            }
            e.printStackTrace();
            return false;
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
    }
    public boolean xoaPhieuNhapHang(String maPNH) {
        Connection conn = null;
        try {
            conn = DatabaseHelper.getConnection();
            conn.setAutoCommit(false);

            if (!pnhDAL.xoaPhieuNhapHang(maPNH, conn)) {
                conn.rollback();
                return false;
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public boolean SuaThongTinPNHVoiChiTietPNH(PhieuNhapHangDTO pnh, List<ChiTietPhieuNhapHangDTO> chiTietMoi) {
        Connection conn = null;
        try {
            conn = DatabaseHelper.getConnection();
            conn.setAutoCommit(false);

            if (!pnhDAL.SuaPNH(pnh, conn)) {
                conn.rollback();
                return false;
            }

            List<ChiTietPhieuNhapHangDTO> chiTietCu = pnhDAL.getTTCTPhieuNhapHang(pnh.getMaPNH(), conn);

            for (ChiTietPhieuNhapHangDTO ctCu : chiTietCu) {
                if (!chiTietMoi.stream().anyMatch(ct -> ct.getMaSP().equals(ctCu.getMaSP()))) {
                    if (!pnhDAL.xoaChiTietPhieuNhapHang(ctCu.getMaPNH(), ctCu.getMaSP(), conn)) {
                        conn.rollback();
                        return false;
                    }
                }
            }

            for (ChiTietPhieuNhapHangDTO ctMoi : chiTietMoi) {
                boolean exists = chiTietCu.stream().anyMatch(ct -> ct.getMaSP().equals(ctMoi.getMaSP()));

                if (exists) {
                    ChiTietPhieuNhapHangDTO ctCu = chiTietCu.stream()
                            .filter(ct -> ct.getMaSP().equals(ctMoi.getMaSP()))
                            .findFirst().get();

                    if (!pnhDAL.SuaChiTietPNH(ctMoi, conn)) {
                        conn.rollback();
                        return false;
                    }
                } else {
                    if (!pnhDAL.ThemCTPNH(ctMoi, conn)) {
                        conn.rollback();
                        return false;
                    }

                }
            }

            double tongTien = pnhDAL.tinhTongTienPhieuNhap(pnh.getMaPNH(), conn);
            if (!pnhDAL.capNhatThanhTien(pnh.getMaPNH(), tongTien, conn)) {
                conn.rollback();
                return false;
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) {}
            }
            e.printStackTrace();
            return false;
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
    }

    public List<ChiTietPhieuNhapHangDTO> layChiTietPhieuNhapHang(String maPNH) {
        return pnhDAL.getTTChiTietPhieuNhapHang(maPNH);
    }

    public List<PhieuNhapHangDTO> XuLyTraCuuPhieuNhapHang(String keyword,
                                                          String fromDateStr, String toDateStr,
                                                          Double minAmount, Double maxAmount) {
        return pnhDAL.timKiemPhieuNhapHang(keyword, fromDateStr, toDateStr, minAmount, maxAmount);
    }

    public PhieuNhapHangDTO layPhieuNhapHangTheoMa(String maPNH) {
        if (maPNH == null || maPNH.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã PNH không hợp lệ");
        }
        return pnhDAL.getTTPhieuNhapHang(maPNH);
    }


    public Map<String, String> layDSSanPham(List<String> danhSachMaSP) {
        return pnhDAL.layDanhSachTenSanPham(danhSachMaSP);
    }

    public boolean kiemTraMaPNHTonTai(String maPNH) {
        return pnhDAL.layDanhSachPhieuNhapHang().stream()
                .anyMatch(p -> p.getMaPNH().equalsIgnoreCase(maPNH));
    }

    public boolean kiemTraNhanVienTonTai(String maNV) {
        return true;
    }

    public boolean kiemTraNhaCungUngTonTai(String maNCU) {
        if (maNCU == null || maNCU.trim().isEmpty()) {
            return false;
        }

        PhieuNhapHangDAL pnhDAL = new PhieuNhapHangDAL();
        return pnhDAL.kiemTraNhaCungUngTonTai(maNCU.trim());    }
}