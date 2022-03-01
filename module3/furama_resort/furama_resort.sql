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
values(1,'Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
(2,'Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
(3,'Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
(4,'Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0333333333','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0322222222','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
(7,'Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0399999999','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
(8,'Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
(9,'Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','217 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao@gmail.com','9 Hoà Khánh, Đồng Nai',2,3,2);

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
values (1,'Nguyễn Thị Hào','1970-11-07','0','643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
(2,'Phạm Xuân Diệu','1992-08-08','1','865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
(3,'Trương Đình Nghệ','1990-02-27','1','488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
(4,'Dương Văn Quan','1981-07-08','1','543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
(5,'Hoàng Trần Nhi Nhi','1995-12-09','0','543432112','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
(6,'Tôn Nữ Mộc Châu','2005-12-06','0','543432113','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
(7,'Nguyễn Mỹ Kim','1984-04-08','0','543432114','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
(8,'Nguyễn Thị Hào','1999-04-08','0','543432115','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
(9,'Trần Đại Danh','1994-07-01','1','543432116','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
(10,'Nguyễn Tâm Đắc','1989-07-01','1','543432117','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);

create table accompanied_service(
a_id int primary key,
a_name varchar(45),
a_price int,
unit varchar(10),
status varchar(45)
);
insert into accompanied_service 	
values (1,'Karaoke',10000,'giờ','tiện nghi, hiện tại'),
(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
(3,'Thuê xe đạp',20000,'chiếc','tốt'),
(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');

create table type_of_service(
type_service_id int primary key,
type_service_name varchar(45)
);
insert into type_of_service 
values(1,'Villa'),
(2,'House'),
(3,'Room');

create table type_of_rental(
type_rental_id int primary key,
type_rental_name varchar(45)
);
insert into type_of_rental
values (1,'year'),
(2,'month'),
(3,'day'),
(4,'hour');

create table service(
service_id int primary key,
service_name varchar(45),
area int,
rental_costs double,
number_of_person int,
room_standard varchar(45),
other_information varchar(45),
pool_area double,
number_of_floor int,
type_rental_id int,
type_service_id int,
foreign key (type_rental_id) references type_of_rental (type_rental_id),
foreign key (type_service_id) references type_of_service (type_service_id)
);
insert into service
values (1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
(2,'House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,2,3,2),
(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',null,4,3,3),
(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
(5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,3,3,2),
(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',null,4,3,3);

create table contract(
contract_id int primary key,
check_in date,
check_out date,
deposit double,
staff_id int,
customer_id int,
service_id int,
foreign key (staff_id)references staff(staff_id),
foreign key (customer_id)references customer(customer_id),
foreign key (service_id)references service(service_id)
);
insert into contract
values(1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',0,7,4,4),
(8,'2021-06-17','2021-06-18',0,3,4,1),
(9,'2020-11-19','2020-11-19',100000,3,4,3),
(10,'2021-04-12','2021-04-14',150000,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,2,1);

create table detail_contract(
detail_contract_id int primary key,
quantity int,
contract_id int,
a_id int ,
foreign key (contract_id) references contract (contract_id),
foreign key (a_id) references accompanied_service  (a_id)
);
insert into detail_contract
values (1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);

-- task2 H,T,K 15max
select* from staff where ((staff_name like 'H%' 
or staff_name like 'T%' 
or staff_name like 'K%')and char_length((staff_name)<=15));

-- task3 customer age 18-50 and adrress 'dn' 'qt'
select * from customer where (datediff(curdate(),customer.day_of_birth)/365<50 and datediff(curdate(),customer.day_of_birth)/365>18)
and (customer.address like '%Đà Nẵng' or customer.address like '%Quảng Trị');

-- task4 count customer (diamond)so lan da dat phong
select customer.customer_id,customer.customer_name, count(customer.customer_id) as `time`
from contract
join customer on customer.customer_id = contract.customer_id
join type_of_customer on type_of_customer.type_id =customer.type_id
where type_of_customer.type_name = 'Diamond'
group by contract.customer_id
order by count(customer.customer_id);