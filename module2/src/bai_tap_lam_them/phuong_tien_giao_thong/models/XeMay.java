package bai_tap_lam_them.phuong_tien_giao_thong.models;

public class XeMay extends PhuongTienGiaoThong{
    private String congSuat;

    public XeMay(){}

    public XeMay(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, String congSuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +"bienKiemSoat: "+getBienKiemSoat()+
                "tenHangSanXuat: "+getTenHangSanXuat()+
                "namSanXuat= "+getNamSanXuat()+
                "chuSoHuu: "+getChuSoHuu()+
                "congSuat: " + congSuat +
                '}';
    }
}
