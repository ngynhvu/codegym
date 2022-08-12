use student_management;
create table Class(
id int primary key not null,
name varchar(40)
);
create table Teacher(
id int auto_increment primary key not null,
name varchar(40),
age int,
country varchar(40)
)