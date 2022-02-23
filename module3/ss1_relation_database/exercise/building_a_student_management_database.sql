drop database if exists my_database;
create database my_database;
use my_database;
create table student(
id_student int primary key auto_increment,
name varchar(45)not null,
age int ,
country varchar(45)not null
);
create table class(
id_class int primary key auto_increment,
name varchar(45)not null);
create table teacher(
id_class int primary key auto_increment,
name varchar(45)not null,
age int ,
country varchar(45)not null );

