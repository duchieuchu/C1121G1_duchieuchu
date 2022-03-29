drop database if exists quan_li_diem_thi;
create database quan_li_diem_thi;
use quan_li_diem_thi;

create table hoc_sinh(
ma_hoc_sinh int primary key,
ten_hoc_sinh varchar(45),
ngay_sinh date,
lop varchar(45),
gioi_tinh varchar(40)
);

create table giao_vien(
ma_giao_vien int primary key,
ten_giao_vien varchar(45),
so_dien_thoai varchar(45)
);

create table mon_hoc(
ma_mon_hoc int primary key,
ten_mon_hoc varchar(45),
ma_giao_vien int ,
foreign key (ma_giao_vien) references giao_vien(ma_giao_vien)
);

create table bang_diem(
ma_hoc_sinh int ,
ma_mon_hoc int,
primary key(ma_hoc_sinh,ma_mon_hoc),
diem_thi varchar(45),
ngay_kiem_tra date,
foreign key (ma_hoc_sinh) references hoc_sinh(ma_hoc_sinh),
foreign key (ma_mon_hoc) references mon_hoc(ma_mon_hoc)
);