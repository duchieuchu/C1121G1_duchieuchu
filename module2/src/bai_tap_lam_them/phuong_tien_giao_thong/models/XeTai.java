package bai_tap_lam_them.phuong_tien_giao_thong.models;

public class XeTai extends PhuongTienGiaoThong{
    private String trongTai;

    public XeTai(){}

    public XeTai(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, String trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{" +" bienKiemSoat: "+getBienKiemSoat()+
                ", tenHangSanXuat: "+getTenHangSanXuat()+
                ", namSanXuat= "+getNamSanXuat()+
                ", chuSoHuu: "+getChuSoHuu()+
                ", trongTai='" + trongTai + '\'' +
                '}';
    }
}
