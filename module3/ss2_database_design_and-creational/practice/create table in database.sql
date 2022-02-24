create database quan_li_diem_thi;
use quan_li_diem_thi;
CREATE TABLE HocSinh(
    ma_hs VARCHAR(20) PRIMARY KEY,
    ten_hs VARCHAR(50),
    ngay_sinh DATETIME,
    lop VARCHAR(20),
    gioi_tinh VARCHAR(20)
);
CREATE TABLE MonHoc(
    ma_mh VARCHAR(20) PRIMARY KEY,
    ten_mh VARCHAR(50)
);
CREATE TABLE BangDiem(
    ma_hs VARCHAR(20),
    ma_mh VARCHAR(20),
    diem_thi INT,
    ngay_kiem_tra DATETIME,
    PRIMARY KEY (ma_hs, ma_mh),
    FOREIGN KEY (ma_hs) REFERENCES HocSinh(ma_hs),
    FOREIGN KEY (ma_mh) REFERENCES MonHoc(ma_mh)
);
CREATE TABLE GiaoVien(
    ma_gv VARCHAR(20) PRIMARY KEY,
    ten_gv VARCHAR(20),
    sdt VARCHAR(10)
);
ALTER TABLE MonHoc ADD ma_gv VARCHAR(20);
ALTER TABLE MonHoc ADD CONSTRAINT FK_ma_gv FOREIGN KEY (ma_gv) REFERENCES GiaoVien(ma_gv);