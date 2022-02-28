drop database if exists furama_resort;
create database furama_resort;
use furama_resort;
create table position (
position_id int primary key,
position_name varchar(45)
);
insert into position 
values (1,'manager'),(2,'staff');

create table education_level(
level_id int primary key,
level_name varchar(45)
);
insert into education_level
values(1,'TC'),(2,'CD'),(3,'DH'),(4,'SDH');

create table part(
part_id int primary key,
part_name varchar(45)
);
insert into part
values(1,'Sale-Marketing'),(2,'Administrative'),(3,'Service'),(4,'Manage');

create table staff(
staff_id int primary key,
staff_name varchar(45),
day_of_birth date,
id_number varchar(45),
salary double,
number_phone varchar(45),
email varchar(45),
address varchar(45),--
position_id int,
level_id int,
part_id int,
foreign key (position_id) references position  (position_id),
foreign key (level_id) references education_level (level_id),
foreign key (part_id) references part (part_id)
);
insert into staff 
values(1,'Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','an@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
(2,'Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binh@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
(3,'Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','yen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
(4,'Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0333333333','phat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0322222222','nghi@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
(7,'Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0399999999','ha@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
(8,'Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','dong@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
(9,'Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoang@gmail.com','217 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','dao@gmail.com','9 Hoà Khánh, Đồng Nai',2,3,2);

create table type_of_customer(
type_id int primary key,
type_name varchar(45)
);
insert into type_of_customer
values (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');

create table customer(
customer_id int primary key,
customer_name varchar(45),
day_of_birth date,
gender varchar(10),	
id_number varchar(45),
number_phone varchar(45),
email varchar(45),
address varchar(45),--
type_id int,
foreign key (type_id) references type_of_customer (type_id)
);
insert into customer
values (1,'lan','2000-12-09','1','1','1','1','1',1),
(2,'linh','2000-12-09','1','1','1','1','1',1),
(3,'luc','2000-12-09','1','1','1','1','1',1),
(4,'dao','2000-12-09','1','1','1','1','1',1),
(5,'hoa','2000-12-09','1','1','1','1','1',1),
(6,'nhi','2000-12-09','1','1','1','1','1',1),
(7,'thuong','2000-12-09','1','1','1','1','1',1),
(8,'hao','2000-12-09','1','1','1','1','1',1),
(9,'ut','2000-12-09','1','1','1','1','1',1),
(10,'trang','2000-12-09','1','1','1','1','1',1);





