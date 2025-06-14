package BLL;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.List;

public class KhachHangBLL {
    private KhachHangDAL khDal = new KhachHangDAL();

    public ArrayList<KhachHangDTO> getAllKhachHang() {
        return khDal.layDSKhachHang();
    }

    public KhachHangDTO getKhachHangById(String maKH) {
        return khDal.getThongTinKhachHang(maKH);
    }

    public boolean XuLyThemKhachHang(KhachHangDTO kh) {
        return khDal.ThemKhachHang(kh);
    }

    public List<KhachHangDTO> XuLyTraCuuKhachHang(String keyword) {
        return khDal.getKhachHang(keyword);
    }

    public boolean SuaThongTinKH(KhachHangDTO kh) {
        return khDal.SuaKhachHang(kh);
    }

    public boolean XoaKhachHang(String maKH) {
        return khDal.XoaKhachHang(maKH);
    }

    public int countKhachHang() {
        return khDal.getTongKH();
    }
}
