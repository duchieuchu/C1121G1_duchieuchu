package BaiThi.models;

public class BenhNhanVip extends BenhNhan{
    private String loaiVip;
    private String thoiHanVip;

    public BenhNhanVip(String loaiVip, String thoiHanVip) {
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public BenhNhanVip(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien, String loaiVip, String thoiHanVip) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    @Override
    public String toString() {
        return "BanhNhanVip{" +
                "soThuTuBenhAn=" + getSoThuTuBenhAn() +
                ", maBenhAn='" + getMaBenhAn()  + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" +getNgayNhapVien()  + '\'' +
                ", ngayRaVien='" +getNgayRaVien()  + '\'' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\'' +
                ", loaiVip='" + loaiVip + '\'' +
                ", thoiHanVip='" + thoiHanVip + '\'' +
                '}';
    }
    public String toStringToFileCSV() {
        return getSoThuTuBenhAn() + "," + getMaBenhAn() + "," + getMaBenhNhan() + "," + getTenBenhNhan()
                + "," + getNgayNhapVien() + "," + getNgayRaVien() + "," + getLiDoNhapVien()
                +","+getLoaiVip()+","+getThoiHanVip();
    }
}
