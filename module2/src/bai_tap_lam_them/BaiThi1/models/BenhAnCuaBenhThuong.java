package bai_tap_lam_them.BaiThi1.models;

public class BenhAnCuaBenhThuong extends BenhAnCuaBenhNhan{
    private double phiNamVien;

    public BenhAnCuaBenhThuong(int soThuTuBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien, double phiNamVien) {
        super(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAnCuaBenhThuong{" +
                "soThuTuBenhAn=" + getSoThuTuBenhAn() +
                ", maBenhAn='" + getMaBenhAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\'' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\'' +
                ", phiNamVien=" + phiNamVien +
                '}';
    }
    public String getInfoToWriteFileCSV(){
        return getSoThuTuBenhAn()+","+getMaBenhAn()+","+getMaBenhNhan()+","+getTenBenhNhan()+
                ","+getNgayNhapVien()+","+getNgayRaVien()+","+getLiDoNhapVien()+","+getPhiNamVien();
    }
}
