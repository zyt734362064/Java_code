drop table if exists classes;
drop table if exists studen;
drop table if exists course;
drop table if exists score;

create table classes (
id int primary key auto_increment,
name varchar(20),
`desc` varchar(10));

create table student (
id int primary key auto_increment,
sn varchar(20),
name varchar(20),
class_id int);

create table course (
id int primary key auto_increment,
name varchar(20));

create table score (
score decimal(3,1),
studen_id int ,
foreign key (studen_id) references student(id),
course_id int ,
foreign key (course_id) references course(id));

insert into classes (name,`desc`) values 
('Java_1班','计算机原理、C、Java语言'),
('Java_2班','数据结构'),
('Java_3班','算法');

insert into student (sn,name,class_id) values 
(0001,'李逵',1),
(0020,'张飞',1),
(0032,'孙尚香',1),
(0039,'兰陵王',2),
(0048,'妲己',1);

