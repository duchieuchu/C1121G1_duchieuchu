package bai_tap_lam_them.phuong_tien_giao_thong.models;

public class OTo extends PhuongTienGiaoThong{
    private int soChoNgoi;
    private String kieuXe;

    public OTo(){}


    public OTo(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "OTo{" + " bienKiemSoat: " +getBienKiemSoat() +
                ", tenHangSanXuat: " + getTenHangSanXuat() +
                ", namSanXuat: " + getNamSanXuat() +
                ", chuSoHuu: " + getChuSoHuu() +
                ", soChoNgoi: " + soChoNgoi +
                ", kieuXe: " + kieuXe +
                '}';
    }
}
