package BLL;

import DAL.LoaiSPDAL;
import DTO.LoaiSPDTO;
import java.util.ArrayList;
import java.util.List;
public class LoaiSPBLL {
	private LoaiSPDAL lspDal = new LoaiSPDAL();

    public ArrayList<LoaiSPDTO> getAllLSP() {
        return lspDal.getAllLSP();
    }

    public LoaiSPDTO getLSPById(String maKH) {
        return lspDal.getTTLoaiSP(maKH);
    }

    public boolean XuLyThemLSP(LoaiSPDTO kh) {
        return lspDal.ThemLSP(kh);
    }

    public List<LoaiSPDTO> XuLyTraCuuLSP(String keyword) {
        return lspDal.getLSP(keyword);
    }

    public boolean SuaThongTinLSP(LoaiSPDTO kh) {
        return lspDal.SuaLSP(kh);
    }

    public boolean XuLyXoaLSP(String maKH) {
        return lspDal.XoaLoaiSanPham(maKH);
    }

}
