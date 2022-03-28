package model;

public class Sach {
    private int idSach;
    private String maSach;
    private TheMuonSach maMuonSach;
    private String tenSach;
    private HocSinh tenHocSinh;
    private TheMuonSach ngayMuon;
    private TheMuonSach ngayTra;
    private String tacGia;
    private String moTa;
    private int soLuong;

    public Sach(int idSach, TheMuonSach maMuonSach, String tenSach, HocSinh tenHocSinh, TheMuonSach ngayMuon, TheMuonSach ngayTra) {
        this.idSach = idSach;
        this.maMuonSach = maMuonSach;
        this.tenSach = tenSach;
        this.tenHocSinh = tenHocSinh;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public Sach(int idSach, String maSach, String tenSach, String tacGia, String moTa, int soLuong) {
        this.idSach = idSach;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    public Sach(String maSach, String tenSach, String tacGia, String moTa, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    public TheMuonSach getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(TheMuonSach maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public HocSinh getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(HocSinh tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
    }

    public TheMuonSach getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(TheMuonSach ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public TheMuonSach getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(TheMuonSach ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
