create database sales_management;
use sales_management;

create table customer (
cID int auto_increment primary key,
cName varchar(50) not null,
cAge int not null
);

create table `order`(
oID int auto_increment primary key,
cID int not null,
oDate datetime not null,
oTotal_price double not null,
foreign key(cID)references customer(cID)
);

create table product(
pID int auto_increment primary key,
pName varchar(50) not null,
pPrice double not null
);

create table order_detail(
oID int not null,
pID int not null,
od_QTY varchar(50) not null,
primary key (oID,pID),
foreign key (oID)references `order`(oID),
foreign key (pID)references product(pID)
);
