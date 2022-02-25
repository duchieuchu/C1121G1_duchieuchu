drop database if exists sales_management ;
create database sales_management;
use sales_management;

create table customer (
cID int auto_increment primary key,
cName varchar(50) not null,
cAge int not null
);

create table `order` (
oId int not null auto_increment primary key,
cId int not null,
oDate date not null,
oTotalPrice double null,
foreign key (cId) references customer(cId)
);

create table product(
pID int auto_increment primary key,
pName varchar(50) not null,
pPrice double null
);

create table order_detail(
oID int not null,
pID int not null,
od_QTY varchar(50) not null,
primary key (oID,pID),
foreign key (oID)references `order`(oID),
foreign key (pID)references product(pID)
);

insert into customer values
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into `Order`values
(1,1,'2006-03-21',null),
(2,2,'2006-03-23',null),
(3,1,'2006-03-16',null);
 
insert into product 
values(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_detail
values(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);