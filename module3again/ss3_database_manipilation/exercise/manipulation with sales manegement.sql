drop database if exists quan_li_ban_hang;
create database quan_li_ban_hang;
use quan_li_ban_hang;

create table customer(
customer_id int primary key ,
customer_name varchar(45) not null,
customer_age tinyint  not null 
);

create table `order` (
order_id int primary key ,
customer_id int not null,
foreign key (customer_id) references customer(customer_id),
order_date date not null,
order_price int 
);

create table product(
product_id int primary key ,
product_name varchar(25)not null,
product_price int not null
);

create table order_detail(
order_id int not null,
product_id int not null,
primary key (order_id,product_id),
foreign key (order_id) references `order`(order_id),
foreign key(product_id) references product(product_id),
order_quantity int not null
);

insert into customer
values (1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into `order`
values(1,1,'2006-03-21',null),
(2,2,'2006-03-23',null),
(3,1,'2006-03-16',null);

insert into product
values(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_detail
values(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select order_id,order_date,order_price from `order`;

select customer.customer_name,product_name from customer
join `order` on customer.customer_id=`order`.customer_id
join order_detail on `order`.order_id=order_detail.order_id
join product on order_detail.product_id = product.product_id;

select customer.customer_name from customer
left join `order` on customer.customer_id=`order`.customer_id
where `order`.order_id is null;

select customer.customer_Name from customer 
left join `order` on customer.customer_ID = `order`.customer_ID
where `order`.order_ID is null;

select `order`.order_id,`order`.order_date,sum(order_detail.order_quantity*product.product_price) as total_price
from `order` join order_detail on `order`.order_id= order_detail.order_id
join product on order_detail.product_id=product.product_id
group by `order`.order_Id
