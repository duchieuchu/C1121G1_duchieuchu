package furama.models;

public class Villa extends Facility {
    //Tiêu chuẩn phòng, Diện tích hồ bơi, Số tầng.
    private String tieuChuanPhong;
    private String dienTichHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String tenDichVu, String dienTichSuDung, int chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, String dienTichHoBoi, int soTang) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(String dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "Villa{" +

                "tenDichVu='" + getTenDichVu() + '\'' +
                ", dienTichSuDung='" + getDienTichSuDung() + '\'' +
                ", chiPhiThue=" + getChiPhiThue() +
                ", soLuongNguoiToiDa=" + getSoLuongNguoiToiDa() +
                ", kieuThue='" + getKieuThue() + '\'' +
                ", tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", dienTichHoBoi='" + dienTichHoBoi + '\'' +
                ", soTang=" + soTang +
                '}';
    }
}
