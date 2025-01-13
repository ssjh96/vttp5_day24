drop database if exists bank;

create database bank;
use bank;

create table BankAccount (
    id int not null auto_increment,
    fullname varchar(150) not null,
    isActive boolean,
    balance float default "100.0",

    constraint pk_bankaccount_id primary key (id)
);

insert into BankAccount (fullName, isActive, balance) 
    values ('Test Account', true, 300.0);

