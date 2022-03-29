drop database if exists xuat_nhap_khau;
create database xuat_nhap_khau;
use xuat_nhap_khau;

create table nha_cung_cap(
ma_nha_cung_cap int primary key not null,
ten_nha_cung_cap varchar(45),
dia_chi varchar(45)
);

create table so_dien_thoai(
id_so_dien_thoai int primary key not null,
so_dien_thoai varchar(45),
ma_nha_cung_cap int not null ,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table don_dat_hang (
so_dat_hang int primary key not null,
ngay_dat_hang date,
ma_nha_cung_cap int not null ,
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table vat_tu (
ma_vat_tu  int primary key not null,
ten_vat_tu varchar(45),
so_dat_hang int
);

create table ddh(
ma_vat_tu  int  not null,
so_dat_hang int  not null,
primary key(ma_vat_tu,so_dat_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key (so_dat_hang) references don_dat_hang(so_dat_hang)
);

create table phieu_xuat(
so_phieu_xuat int primary key not null,
ngay_xuat date
);

create table px(
so_phieu_xuat int  not null,
ma_vat_tu  int  not null,
primary key(so_phieu_xuat,ma_vat_tu),
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
don_gia_xuat varchar(45),
so_luong_xuat int
);

create table phieu_nhap(
so_phieu_nhap int primary key not null,
ngay_nhap date
);

create table pn(
ma_vat_tu int  not null,
so_phieu_nhap int  not null,
primary key(ma_vat_tu,so_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
don_gia_nhap varchar(45),
so_luong_nhap int
);