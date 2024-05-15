create database datasecurity;
use datasecurity;

create table users (
                       id integer primary key auto_increment,
                       firstName nvarchar(30),
                       lastName nvarchar(50),
                       email nvarchar(300),
                       salt nvarchar(100),
                       passwordHash nvarchar(500)
);