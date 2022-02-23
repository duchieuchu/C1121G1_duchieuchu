create database student_management;
use  student_management;
create table student(
id_student int not null,
name varchar(45)not null,
age int );
insert into student 
values(1,"a",19),(2,"b",19),(3,"c",19),(4,"d",19),(5,"e",19)