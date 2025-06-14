package BLL;

import DAL.HangSanXuatDAL;
import DTO.HangSanXuatDTO;
import java.util.List;

public class HangSanXuatBLL {
    private HangSanXuatDAL hangsanxuatDAL = new HangSanXuatDAL();

    public List<HangSanXuatDTO> getAllHangSanXuat() {
        return hangsanxuatDAL.getAllHangSanXuat();
    }

    public boolean XuLyThemHangSanXuat(HangSanXuatDTO hsx) {
        return hangsanxuatDAL.ThemHangSanXuat(hsx);
    }

    public boolean SuaThongTinHSX(HangSanXuatDTO hsx) {
        return hangsanxuatDAL.SuaHSX(hsx);
    }

    public boolean XoaHangSanXuat(String maHSX) {
       return hangsanxuatDAL.XoaHSX(maHSX);
    }
    public HangSanXuatDTO getHSXbyID(String maHSX) {
        return hangsanxuatDAL.getThongTinHSX(maHSX);
    }
    public List<HangSanXuatDTO> XuLyTraCuuHSX(String keyword) {
        return hangsanxuatDAL.XuLyTraCuuHSX(keyword);
    }

}
