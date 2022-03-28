package model;

public class HocSinh {
    private int idHocSinh;
    private String maHocSinh;
    private Sach tenSach;
    private String tenHocSinh;
    private String lop;


    public HocSinh(int idHocSinh, String maHocSinh, String tenHocSinh, String lop) {
        this.idHocSinh = idHocSinh;
        this.maHocSinh = maHocSinh;
        this.tenHocSinh = tenHocSinh;
        this.lop = lop;
    }

    public HocSinh(String maHocSinh, String tenHocSinh, String lop) {
        this.maHocSinh = maHocSinh;
        this.tenHocSinh = tenHocSinh;
        this.lop = lop;
    }

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }


    public Sach getTenSach() {
        return tenSach;
    }

    public void setTenSach(Sach tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
