drop database if exists student_management;
create database student_management;
use student_management;
create table student(
student_id int primary key auto_increment,
student_name varchar(45) not null,
student_age varchar(45) not null,
student_country varchar(45) not null
);

create table class(
class_id int primary key auto_increment,
class_name varchar(45) not null
);

create table teacher(
teacher_id int primary key auto_increment,
teacher_name varchar(45) not null,
teacher_age varchar(45) not null,
teacher_country varchar(45) not null
);