SELECT * FROM quanlinhanvien.class;
insert into class
values(1,'A1','2008-12-20',1),(2,'A2','2008-12-22',1),
(3,'B3',current_date(),0);
delete from class where ClassID =1 or ClassID=2 or classID=3;
 
SELECT * FROM quanlinhanvien.student;
insert into student (studentName,address,phone,status,classID)
values ('Hung','Ha Noi','0333333333',1,1),
('Hoa','Hai Phong',null,1,1),
('Manh','HCM','0333339999',0,2);

select * from quanlinhanvien.subject;
insert into subject values(1,'CF',5,1),
(2,'C',6,1),(3,'HDJ',5,1),(4,'RDBMS',10,1);

SELECT * FROM quanlinhanvien.mark;
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 6, 8, 1),
       (2, 7, 10, 2),
       (3, 8, 12, 1);