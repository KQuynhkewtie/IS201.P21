package BLL;

import DAL.SanPhamDAL;
import DTO.SanPhamDTO;
import java.util.List;

public class SanPhamBLL {
    private SanPhamDAL spDAL;

    public SanPhamBLL() {
        spDAL = new SanPhamDAL();
    }

    public List<SanPhamDTO> getAllSanPham() {
        return spDAL.layDSSanPham();
    }

    public boolean XuLyThemSP(SanPhamDTO sp) {
        return spDAL.ThemSP(sp);
    }

    public boolean SuaThongTinSP(SanPhamDTO sp) {
        return spDAL.SuaSP(sp);
    }

    public List<SanPhamDTO> XuLyTraCuuSP(String keyword) {
        return spDAL.getSanPham(keyword);
    }
    
    public SanPhamDTO getSanPhamById(String maSP) {
        return spDAL.getThongTinSanPham(maSP);
    }

    public boolean XoaSanPham(String maSP) {
        return spDAL.XoaSanPham(maSP);
    }

    public int countSanPham() {
        return spDAL.getTongsp();
    }
}
