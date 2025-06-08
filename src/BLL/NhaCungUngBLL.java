package BLL;


import DAL.NhaCungUngDAL;
import DTO.NhaCungUngDTO;
import java.util.ArrayList;
import java.util.List;

public class NhaCungUngBLL {
    private NhaCungUngDAL ncuDal = new NhaCungUngDAL();

    // Lấy danh sách khách hàng
    public ArrayList<NhaCungUngDTO> getAllNCU() {
        return ncuDal.getAllNCU();
    }

    // Lấy khách hàng theo mã
    public NhaCungUngDTO getNCUById(String maNCU) {
        return ncuDal.getNCUById(maNCU);
    }

    // Thêm khách hàng
    public boolean insertNCU(NhaCungUngDTO NCU) {
        return ncuDal.insertncu(NCU);
    }

    // Tìm kiếm khách hàng theo tên
    public List<NhaCungUngDTO> getNCU(String keyword) {
        return ncuDal.getncu(keyword);
    }

    // Cập nhật thông tin khách hàng
    public boolean updateNCU(NhaCungUngDTO NCU) {
        return ncuDal.updateNCU(NCU);
    }

    public boolean deleteNCUById(String maNCU) {
        return ncuDal.deleteNCUById(maNCU);
    }

}
