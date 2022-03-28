package model;

public class TheMuonSach {
    private int idTheMuonSach;
    private String maMuonSach;
    private String maSach;
    private String maHocSinh;
    private boolean trangThai;
    private String ngayMuon;
    private String ngayTra;
    private int idHocSinh;
    private int idSach;

    public TheMuonSach(int idTheMuonSach, String maMuonSach, String maSach, String maHocSinh, boolean trangThai, String ngayMuon, String ngayTra, int idHocSinh, int idSach) {
        this.idTheMuonSach = idTheMuonSach;
        this.maMuonSach = maMuonSach;
        this.maSach = maSach;
        this.maHocSinh = maHocSinh;
        this.trangThai = trangThai;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.idHocSinh = idHocSinh;
        this.idSach = idSach;
    }

    public int getIdTheMuonSach() {
        return idTheMuonSach;
    }

    public void setIdTheMuonSach(int idTheMuonSach) {
        this.idTheMuonSach = idTheMuonSach;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(String maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }
}
