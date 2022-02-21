package BaiThi.models;

public class BenhNhanThuong extends BenhNhan {
   private double phiNamVien;

    public BenhNhanThuong(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhNhanThuong(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien, double phiNamVien) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien);
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
        return "BenhNhanThuong{" +
                "soThuTuBenhAn=" + getSoThuTuBenhAn() +
                ", maBenhAn='" + getMaBenhAn()  + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" +getNgayNhapVien()  + '\'' +
                ", ngayRaVien='" +getNgayRaVien()  + '\'' +
                ", liDoNhapVien='" + getLiDoNhapVien() + '\'' +
                ", phiNamVien=" + phiNamVien +
                '}';
    }
    public String toStringToFileCSV() {
        return getSoThuTuBenhAn() + "," + getMaBenhAn() + "," + getMaBenhNhan() + "," + getTenBenhNhan() + "," + getNgayNhapVien()
                + "," + getNgayRaVien() + "," + getLiDoNhapVien()+","+getPhiNamVien();
    }
}
