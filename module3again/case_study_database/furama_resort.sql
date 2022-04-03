drop database if exists furama_resort ;
create database  furama_resort ;
use  furama_resort ;

create table position (
position_id int primary key,
position_name varchar(45)
);

insert into position
values(1,'Quan Li'),
(2,'Nhan Vien');

create table education_level (
education_level_id int primary key,
education_level_name varchar(45)
);

insert into education_level 
values (1,'Trung Cấp'),
(2,'Cao Đẳng'),
(3,'Đại Học'),
(4,'Sau Đại Học');

create table part (
part_id int primary key,
part_name varchar(45)
);

insert into part
values (1,'Sale-Marketing'),
(2,'Hành chính'),
(3,'Phục vụ'),
(4,'Quản lý');

create table employee(
employee_id int primary key,
employee_name varchar(45) not null,
day_of_birth date not null,
id_number varchar(45) not null,
salary double not null,
number_phone varchar(45) not null,
email varchar(45),
address varchar(45),
position_id int not null,
education_level_id int not null,
part_id int not null,
foreign key (position_id) references position (position_id) on update cascade on delete cascade,
foreign key (education_level_id) references education_level (education_level_id) on update cascade on delete cascade,
foreign key (part_id) references part (part_id) on update cascade on delete cascade
);

insert into employee
values (1,'Nguyễn Văn An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
(2,'Lê Văn Bình','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','22 Yên Bái',1,2,2),
(3,'Hồ Thị Yến','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
(4,'Võ Công Toản','1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh Phát','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
(6,'Khúc Nguyễn An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
(7,'Nguyễn Hữu Hà','1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
(8,'Nguyễn Hà Đông','1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
(9,'Tòng Hoang','1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công Đạo','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
create table type_of_customer (
type_of_customer_id int primary key,
type_of_customer_name varchar(45)
);

insert into type_of_customer 
values (1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

create table customer (
customer_id int primary key,
type_of_customer_id int not null,
foreign key (type_of_customer_id) references type_of_customer(type_of_customer_id) on update cascade on delete cascade,
customer_name varchar(45) not null,
day_of_birth date not null,
gender bit not null,
id_number varchar(45) not null,
number_phone varchar(45) not null,
email  varchar(45) ,
address  varchar(45) 
);

insert into customer
values (1,5,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng'),
(2,3,'Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị'),
(3,1,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh'),
(4,1,'Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng'),
(5,4,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai'),
(6,4,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng'),
(7,1,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh'),
(8,3,'Nguyễn Thị Hào','199-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum'),
(9,1,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi'),
(10,2,'Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng');


create table type_of_rental (
type_of_rental_id int primary key,
type_of_rental_name varchar(45)
);

insert into type_of_rental
values (1,'year'),
(2,'month'),
(3,'day'),
(4,'hour');

create table type_of_service (
type_of_service_id int primary key,
type_of_service_name varchar(45)
);

insert into type_of_service
values (1,'Villa'),
(2,'House'),
(3,'Room');

create table service (
service_id int primary key,
service_name varchar(45) not null,
area int,
rental_cost double not null,
max_people int,
type_of_rental_id int not null,
type_of_service_id int not null,
foreign key (type_of_rental_id) references type_of_rental(type_of_rental_id) on update cascade on delete cascade,
foreign key (type_of_service_id) references type_of_service(type_of_service_id) on update cascade on delete cascade,
room_standard varchar(45),
other_infomation varchar(45),
pool_area double,
number_of_floor int
);

insert into service
values (1,'Villa Beach Front',25000,10000000,10,3,1,'vip','Có hồ bơi',500,4),
(2,'House Princess 01',14000,5000000,7,3,2,'vip','Có thêm bếp nướng',null,2),
(3,'Room Twin 01',5000,1000000,2,3,3,'normal','Có tivi',null,4),
(4,'Villa No Beach Front',22000,9000000,8,3,1,'normal','Có hồ bơi',300,3),
(5,'House Princess 02',10000,4000000,5,3,2,'normal','Có thêm bếp nướng',null,3),
(6,'Room Twin 02',3000,900000,2,3,3,'normal','Có tivi',null,4);

create table accompanied_service (
accompanied_service_id int primary key,
accompanied_service_name varchar(45) not null,
accompanied_service_price double not null,
unit varchar(10) not null,
`status` varchar(45)
);

insert into accompanied_service 
values (1,'Karaoke',10000,'giờ','tiện nghi, hiện tại'),
(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
(3,'Thuê xe đạp',20000,'chiếc','tốt'),
(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');

create table contract (
contract_id int primary key,
check_in datetime not null,
check_out datetime not null,
deposit double not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
foreign key (employee_id) references employee(employee_id) on update cascade on delete cascade,
foreign key (customer_id) references customer(customer_id) on update cascade on delete cascade,
foreign key (service_id) references service(service_id) on update cascade on delete cascade
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

create table detail_contract (
detail_contract_id int primary key,
contract_id int not null,
accompanied_service_id int not null,
-- unique(contract_id,accompanied_service_id),
foreign key (contract_id) references contract(contract_id) on update cascade on delete cascade,
foreign key (accompanied_service_id) references accompanied_service(accompanied_service_id) on update cascade on delete cascade,
quantity int not null
);

insert into detail_contract
values (1,2,4,5),
(2,2,5,8),
(3,2,6,15),
(4,3,1,1),
(5,4,2,11),
(6,1,3,1),
(7,1,2,2),
(8,12,2,2);

-- task2
-- select * from employee where employee_name like 'H%' 
-- or employee_name like 'T%'
--  or employee_name  like 'K%'and char_length(employee_name)<=15; 

-- task 3
-- select* from customer where (datediff(curdate(),day_of_birth)/365<50 and datediff(curdate(),day_of_birth)/365>18)
-- and (address like '%Đà Nẵng' or address like  '%%Quảng Trị');

-- task 4
-- select customer.customer_id,customer.customer_name, count(customer.customer_id) as 'times'
-- from contract 
-- join customer on contract.customer_id = customer.customer_id
-- join type_of_customer on customer.type_of_customer_id =type_of_customer.type_of_customer_id
-- where type_of_customer.type_of_customer_name ='Diamond'
-- group by customer.customer_id
-- order by  count(customer.customer_id);

-- task 5
-- select customer.customer_id,customer.customer_name,type_of_customer.type_of_customer_name,
-- contract.contract_id,service.service_name,contract.check_in,contract.check_out,
-- (service.rental_cost+detail_contract.quantity*accompanied_service.accompanied_service_price) as total_money
-- from contract 
-- left join customer on contract.customer_id = customer.customer_id
-- left join type_of_customer on customer.type_of_customer_id = type_of_customer.type_of_customer_id
-- left join service on contract.service_id =service.service_id
-- left join detail_contract on contract.contract_id = detail_contract.contract_id
-- left join accompanied_service on accompanied_service.accompanied_service_id= detail_contract.accompanied_service_id
-- group by contract_id; 

-- task 6 
-- select service.service_id , service.service_name,area,service.rental_cost,type_of_service.type_of_service_name
-- from type_of_service
-- join service on type_of_service.type_of_service_id = service.type_of_service_id
-- join contract on contract.service_id= service.service_id
-- where contract.check_in not between '2021-1-1 00:00:00' and '2021-3-31 23:59:59'
-- group by service.service_id;

-- task 7
-- select service.service_id, service.service_name, service.area,
-- service.max_people , service.rental_cost, 
-- type_of_service.type_of_service_name
-- from type_of_service
-- inner join service on type_of_service.type_of_service_id = service.type_of_service_id
-- left join contract on contract.service_id= service.service_id
-- where (contract.check_in between '2020-1-1 00:00:00' and '2020-12-31 23:59:59')
-- and (contract.check_in not between '2021-1-1 00:00:00' and '2021-12-31 23:59:59')
-- group by service.service_id;

-- task 8
-- c1
-- select customer_name from customer
-- group by customer_name;

-- c2
-- select distinct customer_name from customer;

-- c3
-- select customer_name from customer
-- union
-- select customer_name from customer

-- task 9
-- select month(contract.check_in) as thang_lam_hop_dong, count(contract.contract_id) as so_luong_hop_dong
-- from contract
-- join customer on contract.customer_id = customer.customer_id
-- group by thang_lam_hop_dong
-- order by thang_lam_hop_dong;

-- task 10
-- select contract.contract_id, contract.check_in, contract.check_out, contract.deposit, 
-- accompanied_service.accompanied_service_name, sum(ifnull(detail_contract.quantity,0)) as quantity, detail_contract.detail_contract_id
-- from contract
-- left join detail_contract on detail_contract.contract_id = contract.contract_id
-- left join accompanied_service on accompanied_service.accompanied_service_id = detail_contract.accompanied_service_id
-- group by contract.contract_id;

-- task 11
-- select accompanied_service.accompanied_service_id, accompanied_service.accompanied_service_name
-- from type_of_customer
-- inner join customer on type_of_customer.type_of_customer_id = customer.type_of_customer_id
-- inner join contract on contract.customer_id =  customer.customer_id
-- inner join detail_contract on detail_contract.contract_id = contract.contract_id
-- inner join accompanied_service on accompanied_service.accompanied_service_id = detail_contract.accompanied_service_id
-- where type_of_customer.type_of_customer_name = 'Diamond' and (customer.address like '%Vinh' or customer.address like '%Quảng Ngãi');

-- task 12
-- select contract.contract_id, employee.employee_name,customer.customer_name,customer.number_phone,
-- service.service_name,sum(detail_contract.quantity) as so_luong_dich_vu_di_kem,contract.deposit
-- from customer
-- inner join contract on contract.customer_id = customer.customer_id
-- inner join employee on employee.employee_id = contract.employee_id
-- inner join service on contract.service_id = service.service_id
-- left join detail_contract on detail_contract.contract_id = contract.contract_id
-- left join accompanied_service  on accompanied_service.accompanied_service_id = detail_contract.accompanied_service_id
-- where (contract.check_in between '2020-10-1 00:00:00' and '2020-12-31 23:59:59')
-- and (contract.check_in not between '2021-1-1 00:00:00' and '2021-6-30 23:59:59')
-- group by contract.contract_id;

-- task 13
-- select accompanied_service.accompanied_service_id, accompanied_service.accompanied_service_name, sum(detail_contract.quantity) as 'so_luong_dich_vu_di_kem'
-- from accompanied_service
-- join detail_contract on accompanied_service.accompanied_service_id = detail_contract.accompanied_service_id
-- join contract on detail_contract.contract_id = contract.contract_id
-- group by accompanied_service.accompanied_service_id
-- having so_luong_dich_vu_di_kem >= all(select quantity from detail_contract);

-- task 14
-- select contract.contract_id,type_of_service.type_of_service_name,accompanied_service.accompanied_service_name,
-- count(accompanied_service.accompanied_service_id) as so_lan_su_dung
-- from contract
-- join service on contract.service_id = service.service_id
-- join type_of_service on service.type_of_service_id= type_of_service.type_of_service_id
-- join detail_contract on contract.contract_id = detail_contract.contract_id
-- join accompanied_service on detail_contract.accompanied_service_id = accompanied_service.accompanied_service_id
-- group by accompanied_service.accompanied_service_id
-- having count(accompanied_service.accompanied_service_id) = 1
-- order by contract.contract_id;

-- task 15
-- select employee.employee_id, employee.employee_name, education_level.education_level_name, part.part_name, employee.number_phone, employee.address
-- from employee
-- inner join education_level on employee.education_level_id= education_level.education_level_id
-- inner join part on employee.part_id= part.part_id
-- inner join contract on employee.employee_id= contract.employee_id
-- group by employee.employee_id
-- having count(contract.contract_id) <=3;

-- task 16
-- select * from employee;
-- set sql_safe_updates = 0;
-- delete from employee
-- where employee_id not in(
-- select contract.employee_id 
-- from contract
-- where year(contract.check_in) between 2019 and 2021
-- );
-- set sql_safe_updates = 1;
-- select * from employee;

-- task 17
-- select * from customer;
-- update customer
-- set customer.type_of_customer_id = 1
-- where customer.type_of_customer_id= 2
-- and customer.type_of_customer_id in (select contract.customer_id from contract
-- inner join service on contract.service_id = service.service_id
-- inner join detail_contract on contract.contract_id = detail_contract.contract_id
-- inner join accompanied_service on detail_contract.accompanied_service_id = accompanied_service.accompanied_service_id
-- group by contract.customer_id
-- having sum(service.rental_cost + detail_contract.quantity * accompanied_service.accompanied_service_price) > 10000000);


-- task 18
--  select * from customer;
--  set sql_safe_updates =0;
--  delete from customer
--  where customer.customer_id in (
--  select contract.customer_id 
--  from contract
--  where year(contract.check_in) < 2021
--  );
--  select * from customer;
--  set sql_safe_updates =1;

-- task 19
-- select * from accompanied_service;
-- set sql_safe_updates =0;
-- update accompanied_service
-- set accompanied_service.accompanied_service_price = accompanied_service.accompanied_service_price*2
-- where accompanied_service.accompanied_service_id in (
-- select detail_contract.accompanied_service_id 
-- from detail_contract 
-- where detail_contract.quantity > 10
-- );
-- set sql_safe_updates =1;
-- select * from accompanied_service;

-- task 20

 
 
