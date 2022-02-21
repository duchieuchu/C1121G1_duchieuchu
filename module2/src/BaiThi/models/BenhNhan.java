package BaiThi.models;

public abstract class BenhNhan {
    //Số thứ tự bệnh án, Mã bệnh án, Tên bệnh nhân, Ngày nhập viện, Ngày ra viện, Lý do nhập viện
    static int number = 1;
    private int soThuTuBenhAn;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String liDoNhapVien;

    public BenhNhan() {
        soThuTuBenhAn = number++;
    }

    public BenhNhan(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien) {
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.liDoNhapVien = liDoNhapVien;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        BenhNhan.number = number;
    }

    public int getSoThuTuBenhAn() {
        return soThuTuBenhAn;
    }

    public void setSoThuTuBenhAn(int soThuTuBenhAn) {
        this.soThuTuBenhAn = soThuTuBenhAn;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLiDoNhapVien() {
        return liDoNhapVien;
    }

    public void setLiDoNhapVien(String liDoNhapVien) {
        this.liDoNhapVien = liDoNhapVien;
    }

    @Override
    public String toString() {
        return "BenhNhan{" +
                "soThuTuBenhAn=" + soThuTuBenhAn +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", maBenhNhan='" + maBenhNhan + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", liDoNhapVien='" + liDoNhapVien + '\'' +
                '}';
    }

    public String toStringToFileCSV() {
        return soThuTuBenhAn + "," + maBenhAn + "," + maBenhNhan + "," + tenBenhNhan + "," +
                ngayNhapVien + "," + ngayRaVien + "," + liDoNhapVien;
    }
}
