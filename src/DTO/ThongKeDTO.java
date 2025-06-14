package DTO;

import java.util.Date;

public class ThongKeDTO {
    private Date ngay;
    private String thang;
    private String nam;
    private String cumNgay;
    private double doanhThu;
    private int soHoaDon;
    private boolean isYearly;

    public ThongKeDTO() {
    }

    public ThongKeDTO(Date ngay, double doanhThu, int soHoaDon) {
        this.ngay = ngay;
        this.doanhThu = doanhThu;
        this.soHoaDon = soHoaDon;
    }
    public ThongKeDTO(String thang, double doanhThu, int soHoaDon, boolean isMonth) {
        if (isMonth) {
            this.thang = thang;
        } else {
            this.cumNgay = thang;
        }
        this.doanhThu = doanhThu;
        this.soHoaDon = soHoaDon;
    }

    public ThongKeDTO(String nam, double doanhThu, int soHoaDon) {
        this.nam = nam;
        this.doanhThu = doanhThu;
        this.soHoaDon = soHoaDon;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getCumNgay() {
        return cumNgay;
    }

    public void setCumNgay(String cumNgay) {
        this.cumNgay = cumNgay;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }
}