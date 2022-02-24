create database xuat_nhap_khau;
use xuat_nhap_khau;

create table NhaCungCap(
ma_nha_cung_cap int auto_increment primary key,
ten_nha_cung_cap varchar(100),
dia_chi varchar(100)
);

create table SoDienThoai(
ma_so_dien_thoai varchar(100 ) primary key,
ma_nha_cung_cap int,
so_dien_thoai int,
foreign key (ma_nha_cung_cap)references NhaCungCap(ma_nha_cung_cap)
);

create table DonDatHang(
so_don_dat_hang int auto_increment primary key,
ngay_dat_hang date,
ma_nha_cung_cap int,
foreign key (ma_nha_cung_cap)references NhaCungCap(ma_nha_cung_cap)
);

create table VatTu(
ma_vat_tu int auto_increment primary key,
ten_vat_tu varchar(100),
so_don_dat_hang varchar(100)
);

create table DDH(
so_don_dat_hang int,
ma_vat_tu int,
primary key(so_don_dat_hang,ma_vat_tu),
foreign key (so_don_dat_hang)references DonDatHang(so_don_dat_hang),
foreign key (ma_vat_tu)references VatTu(ma_vat_tu)
);

create table PhieuXuat(
so_phieu_xuat int auto_increment primary key,
ngay_xuat datetime
);

create table PX(
don_gia_xuat_khau int,
so_luong_xuat_khau int,
so_phieu_xuat int,
ma_vat_tu int,
primary key(so_phieu_xuat,ma_vat_tu),
foreign key (so_phieu_xuat)references PhieuXuat(so_phieu_xuat),
foreign key (ma_vat_tu)references VatTu(ma_vat_tu)
);

create table PhieuNhap(
so_phieu_nhap int auto_increment primary key,
ngay_nhap datetime
);

create table PN(
don_gia_nhap_khau int,
so_luong_nhap int,
ma_vat_tu int,
so_phieu_nhap int,
primary key(ma_vat_tu,so_phieu_nhap),
foreign key (so_phieu_nhap)references PhieuNhap(so_phieu_nhap),
foreign key (ma_vat_tu)references VatTu(ma_vat_tu)
);