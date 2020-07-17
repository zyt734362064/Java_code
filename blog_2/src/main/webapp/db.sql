drop database if exists blogdemo;
create database blogdemo;
use blogdemo;

drop table if exists user;
create table user (
    userId int primary key auto_increment.
    name varchar(50),
    password varchar(50)
);

drop table if exists article (
    articleId int primary key auto_increment,
    title varchar(50),
    content text,
    userId int,
    foregin key(userId) references user(userId)
);