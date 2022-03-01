drop database if exists quan_li_nhan_vien;
create database quan_li_nhan_vien;
use quan_li_nhan_vien;

create table class(
class_id int primary key auto_increment not null,
class_name varchar(60) not null,
start_date date not null,
status bit 
);
insert into class
values (1,'A1','2008-12-20',1),
(2,'A2','2008-12-22',1),
(3,'B3',current_date(),0);

create table student(
student_id int primary key auto_increment not null,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
status bit ,
class_id int not null,
foreign key (class_id) references class (class_id)
);
insert into student 
values (1,'Hung','Ha Noi','0333333333',1,1),
(2,'Hoa','Hai Phong',null,1,1),
(3,'Manh','HCM','0333339999',0,2);

create table subject(
sub_id int primary key auto_increment not null,
sub_name varchar(30) not null,
credit tinyint not null default 1 check (credit >=1),
status bit  default 1
);
insert into subject
values (1,'CF',5,1),
 (2,'C',6,1),
  (3,'HDJ',5,1),
   (4,'RDBMS',10,1);

create table mark(
mark_id  int not null primary key auto_increment,
sub_id int not null,
student_id int not null,
unique (sub_id,student_id),
foreign key (sub_id) references subject (sub_id),
foreign key (student_id) references student (student_id),
mark float default 0 check ( mark between 0 and 100),
exam_times tinyint default 1 
);
insert into mark
values (1,1,1,8,1),
(2,1,2,10,2),
(3,2,1,12,1);

select address, count(student_id) as 'so luong sinh vien'
from student
group by address;

SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name;

SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name;

SELECT S.Student_Id,S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
HAVING AVG(Mark) > 15;

SELECT S.Student_Id, S.Student_Name, AVG(Mark)
FROM Student S join Mark M on S.Student_Id = M.Student_Id
GROUP BY S.Student_Id, S.Student_Name
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.Student_Id);


