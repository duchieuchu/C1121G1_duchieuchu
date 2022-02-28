drop database if exists sales_management ;
create database sales_management;
use sales_management;

CREATE TABLE customer (
    cID INT AUTO_INCREMENT PRIMARY KEY,
    cName VARCHAR(50) NOT NULL,
    cAge INT NOT NULL
);

CREATE TABLE `order` (
    oId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cId INT NOT NULL,
    oDate DATE NOT NULL,
    oTotalPrice DOUBLE NULL,
    FOREIGN KEY (cId)
        REFERENCES customer (cId)
);

CREATE TABLE product (
    pID INT AUTO_INCREMENT PRIMARY KEY,
    pName VARCHAR(50) NOT NULL,
    pPrice DOUBLE NULL
);

CREATE TABLE order_detail (
    oID INT NOT NULL,
    pID INT NOT NULL,
    od_QTY VARCHAR(50) NOT NULL,
    PRIMARY KEY (oID , pID),
    FOREIGN KEY (oID)
        REFERENCES `order` (oID),
    FOREIGN KEY (pID)
        REFERENCES product (pID)
);

insert into customer values
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50),
(4, 'Hong Hanh', 50);

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

insert into order_detail values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
-- SELECT * FROM `order`; hien thi het du lieu cua order
SELECT 
    oID, oDate, oTotalPrice
FROM
    `order`sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.cId, customer.cName,product.pName 
from customer
join `order` on customer.cID = `order`.cID
join order_detail on `order`.oId =order_detail.oId
join product on order_detail.pID = product.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.cName from customer 
left join `order` on customer.cID = `order`.cID
where `order`.oID is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
select `order`.oId, `order`.oDate, sum(product.pPrice*order_detail.od_QTY) as oTotalPrice
from `order`
join order_detail on order_detail.oId = `order`.oId
join product on product.pId = order_detail.pId
group by `order`.oId