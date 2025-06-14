package BLL;

import java.sql.SQLException;

import DAL.TaiKhoanDAL;

public class TaiKhoanBLL {
    private TaiKhoanDAL taiKhoanDAL = new TaiKhoanDAL();

    public String XuLyDN(String email, String matKhau) throws SQLException {
        return taiKhoanDAL.KiemTraTT(email, matKhau);
    }

    public int TaoTaiKhoan(String tenTK, String email, String matKhau, String manv) {
        return taiKhoanDAL.dangKyTaiKhoan(tenTK, email, matKhau, manv);
    }

    public String getusername(String email) {
        return taiKhoanDAL.getUsername(email);
    }

    public String getmaVaiTro(String maNhanVien) {
        return taiKhoanDAL.getVaiTro(maNhanVien);
    }

    public boolean CapNhatMKMoi(String email, String matKhauMoi) {
        return taiKhoanDAL.CapNhatMKMoi(email, matKhauMoi);
    }

}