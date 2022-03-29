drop database if exists quan_li_ban_hang;
create database quan_li_ban_hang;
use quan_li_ban_hang;

create table customer(
customer_id int primary key not null,
customer_name varchar(45) not null,
customer_age varchar(45)  not null 
);

create table `order` (
order_id int primary key not null,
customer_id int not null,
foreign key (customer_id) references customer(customer_id),
order_date date not null,
order_price varchar(45) not null
);

create table product(
product_id int primary key not null,
product_name varchar(45)not null,
product_price varchar(45) not null
);

create table order_detail(
order_id int not null,
product_id int not null,
primary key (order_id,product_id),
foreign key (order_id) references `order`(order_id),
foreign key(product_id) references product(product_id),
order_quantity int not null
);