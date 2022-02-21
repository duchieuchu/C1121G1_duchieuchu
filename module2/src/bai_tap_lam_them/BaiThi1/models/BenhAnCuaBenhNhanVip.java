package bai_tap_lam_them.BaiThi1.models;

public class BenhAnCuaBenhNhanVip extends BenhAnCuaBenhNhan{
    private String loaiVip;
    private String thoiHanVip;

    public BenhAnCuaBenhNhanVip(int soThuTuBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien, String loaiVip, String thoiHanVip) {
        super(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
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
        return "BenhAnCuaBenhNhanVip{" +
                "soThuTuBenhAn=" + getSoThuTuBenhAn() +
                ", maBenhAn='" + getMaBenhAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\'' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\'' +
                ", loaiVip='" + loaiVip + '\'' +
                ", thoiHanVip='" + thoiHanVip + '\'' +
                '}';
    }
    public String getInfoToWriteFileCSV(){
        return getSoThuTuBenhAn()+","+getMaBenhAn()+","+getMaBenhNhan()+","+getTenBenhNhan()+
                ","+getNgayNhapVien()+","+getNgayRaVien()+","+getLiDoNhapVien()+","+getLoaiVip()+
                ","+getThoiHanVip();
    }
}
