drop database if exists demo;
create database  demo;
use  demo;

create table product (
product_id int primary key auto_increment,
product_code varchar(45),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status bit
); 

insert into product (product_code,
product_name ,
product_price ,
product_amount ,
product_description ,
product_status )
 values ('S0001','IPhone 1',100,10,'do co',1),
 ('S0002','IPhone 1',1000,10,'do co',1),
 ('S0003','IPhone 2',2000,5,'do co',1),
 ('S0004','IPhone 3',3000,7,'do co',1),
 ('S0005','IPhone 4',4000,2,'hang moi',0),
 ('S0006','IPhone 5',5000,1,'hang moi',1);
 
-- explain select * from product where product_name= 'Iphone 2';
-- create unique index index_product_code on product (product_code);
-- explain select * from product where product_code='S0002';
-- create index index_name_price on product (product_name, product_price);
-- explain select * from product where product_name='Iphone 5';

create view product_view as
select product_code, product_name, product_price, product_status from product;
set sql_safe_updates=0;
update product_view set product_price =10 where product_code='S0006';
-- drop view product_view;
delete from product_view ;
DELIMITER //
CREATE procedure product_display()
begin
select*
from product;
end //
DELIMITER ;

DELIMITER //
create procedure insert_new_product (product_code varchar(45), product_name varchar(45),
product_price int,product_status bit)
 begin
insert into product (product_code,product_name,product_price,product_status) values
(product_code,product_name,product_price,product_status);
 end //
DELIMITER ;
call insert_new_product('S1007','Iphone 14', 3000000, 1);
 DELIMITER //
create procedure edit_product (new_id int,new_code varchar(45), new_name varchar(45),
new_price int,new_status bit)
 begin
update product
set product_code = new_code,
product_name = new_name,
product_price = new_price,
product_status =new_status
where  product_id = new_id;
 end //
 DELIMITER ;
 call edit_product(7,'S1008','Iphone 14 P', 3000000, 1);
 
 DELIMITER //
create procedure delete_product (new_id int)
 begin
delete 
from product
where product_id = new_id ;
 end //
DELIMITER ;
call delete_product(2);