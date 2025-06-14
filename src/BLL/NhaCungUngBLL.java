package BLL;


import DAL.NhaCungUngDAL;
import DTO.NhaCungUngDTO;
import java.util.ArrayList;
import java.util.List;

public class NhaCungUngBLL {
    private NhaCungUngDAL ncuDal = new NhaCungUngDAL();

    public ArrayList<NhaCungUngDTO> getAllNCU() {
        return ncuDal.getAllNCU();
    }

    public NhaCungUngDTO getNCUById(String maNCU) {
        return ncuDal.getThongTinNCU(maNCU);
    }

    public boolean XuLyThemNCU(NhaCungUngDTO NCU) {
        return ncuDal.ThemNCU(NCU);
    }

    public List<NhaCungUngDTO> XuLyTraCuuNCU(String keyword) {
        return ncuDal.TimKiemNCU(keyword);
    }

    public boolean SuaThongTinNhaCungUng(NhaCungUngDTO NCU) {
        return ncuDal.SuaNhaCungUng(NCU);
    }

    public boolean XoaNhaCungUng(String maNCU) {
        return ncuDal.XoaNCU(maNCU);
    }

}
