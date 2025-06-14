package BLL;

import DAL.ThongKeDAL;
import DTO.ThongKeDTO;

import java.util.Date;
import java.util.List;

public class ThongKeBLL {
    private ThongKeDAL thongKeDAL;

    public ThongKeBLL() {
        this.thongKeDAL = new ThongKeDAL();
    }


    public double[] getChartDataForMonth(String thangNam) {
        List<ThongKeDTO> data = thongKeDAL.getDoanhThuTheoCumNgayTrongThang(thangNam);
        double[] values = new double[6];

        for (ThongKeDTO item : data) {
            String cumNgay = item.getCumNgay();
            if (cumNgay == null) continue;

            int index = -1;
            if (cumNgay.equals("1-5")) index = 0;
            else if (cumNgay.equals("6-10")) index = 1;
            else if (cumNgay.equals("11-15")) index = 2;
            else if (cumNgay.equals("16-20")) index = 3;
            else if (cumNgay.equals("21-25")) index = 4;
            else if (cumNgay.equals("26-31")) index = 5;

            if (index != -1) {
                values[index] = item.getDoanhThu();
            }
        }

        return values;
    }

    public double[] getChartDataForYear(String nam) {
        List<ThongKeDTO> data = thongKeDAL.getDoanhThu12Thang(nam);
        double[] values = new double[12];

        for (int i = 0; i < 12; i++) {
            values[i] = data.get(i).getDoanhThu();
        }

        return values;
    }

    public double[] getChartDataForTotal(String currentYear) {
        List<ThongKeDTO> data = thongKeDAL.getDoanhThu5NamGanNhat(currentYear);
        double[] values = new double[5];

        for (int i = 0; i < 5; i++) {
            values[i] = data.get(i).getDoanhThu();
        }

        return values;
    }

    public List<ThongKeDTO> TraCuuDoanhThuTheoNgay(Date ngay) {
        return thongKeDAL.getDoanhThuTheoNgay(ngay);
    }

    public List<ThongKeDTO> TraCuuDoanhThuTheoThang(String thangNam) {
        return thongKeDAL.getDoanhThuTungNgayTrongThang(thangNam);
    }

    public List<ThongKeDTO> TraCuuDoanhThuTheoNam(String nam) {
        return thongKeDAL.getDoanhThu12Thang(nam);
    }

    public List<ThongKeDTO> TraCuuDoanhThuTong(String currentYear) {
        return thongKeDAL.getDoanhThu5NamGanNhat(currentYear);
    }

    public String formatCurrency(double amount) {
        return String.format("%,.0f VNĐ", amount);
    }

}