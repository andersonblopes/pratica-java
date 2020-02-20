create database crud;

use crud;

create table user(
id bigint not null auto_increment,
name varchar(60) not null,
login varchar(60) not null,
password varchar(60) not null,
primary key (id)
);