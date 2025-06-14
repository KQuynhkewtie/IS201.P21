package BLL;


import DAL.NhanVienDAL;
import DTO.NhanVienDTO;

import java.util.List;

public class NhanVienBLL {
    private NhanVienDAL nhanVienDAL= new NhanVienDAL();
    public List<NhanVienDTO> getAllNhanVien() {
        return nhanVienDAL.getAllNhanVien();
    }

    public boolean XuLyThemNhanVien(NhanVienDTO nv) {
        return nhanVienDAL.ThemNhanVien(nv);
    }

    public boolean SuaThongTinNhanVien(NhanVienDTO nv) {
        return nhanVienDAL.SuaNhanVien(nv);
    }

    public boolean XoaNhanVien(String maNhanVien) {

        return nhanVienDAL.XoaNhanVien(maNhanVien);
    }

   
    public NhanVienDTO getNhanVienByID(String maNhanVien) {
        return nhanVienDAL.getThongTinNhanVien(maNhanVien);
    }
    public List<NhanVienDTO> XuLyTraCuuNhanVien(String keyword) {
        return nhanVienDAL.TimKiemNhanVien(keyword);
    }


    public int countNhanVien() {
        return nhanVienDAL.getTongnv();
    }
}

