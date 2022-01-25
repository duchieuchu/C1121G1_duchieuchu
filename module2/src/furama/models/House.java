package furama.models;

public class House extends Facility{
    //Tiêu chuẩn phòng, Số tầng.
    private String tieuChuanPhong;
    private int soTang;

    public House() {
    }

    public House(String tenDichVu, String dienTichSuDung, int chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, int soTang) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "House{" +
                "tenDichVu='" + getTenDichVu() + '\'' +
                ", dienTichSuDung='" + getDienTichSuDung() + '\'' +
                ", chiPhiThue=" + getChiPhiThue() +
                ", soLuongNguoiToiDa=" + getSoLuongNguoiToiDa() +
                ", kieuThue='" + getKieuThue() + '\'' +
                ", tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", soTang=" + soTang +
                '}';
    }
}
