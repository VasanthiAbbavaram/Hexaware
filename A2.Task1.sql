drop database if exists HMBank;
create database HMBank;
use HMBank;

drop table if exists Customers;
drop table if exists Accounts;
drop table if exists Transactions;

create table Customers(
	customer_id int primary key,
    first_name varchar(30),
	last_name varchar(30),
    DOB date,
	email varchar(100),
	phone_number varchar(20),
	address varchar(255)
);
desc Customers;

create table Accounts(
	account_id int primary key,
    customer_id int,
    account_type  varchar(20),
    balance decimal(20,2),
	foreign key(customer_id) references Customers(customer_id)
);
desc Accounts;

create table Transactions(
	transaction_id int primary key,
    account_id int,
    transaction_type varchar(20),
    amount decimal(10,2),
    transaction_date date,
    foreign key(account_id) references Accounts(account_id)
);
desc transactions;

-- 1. Insert at least 10 sample records into each of the following tables. 

use hmbank;
insert into Customers(customer_id,first_name,last_name,DOB,email,phone_number,address)
values
(1, 'John', 'Doe', '1990-03-23','john.doe@gmail.com', '1234567890', '123 Main St'),
(2, 'Jane', 'Smith','1993-09-02', 'jane.smith@mail.com', '9876543210', '456 Elm St'),
(3, 'Alice', 'Johnson', '2000-11-07','alice.johnson@mail.com', '5551234567', '789 Oak St'),
(4, 'Bob', 'Williams', '1899-09-24','bob.williams@mail.com', '9876543210', '321 Pine St'),
(5, 'Emily', 'Brown', '2002-09-07','emily.brown@mail.com', '5559876543', '654 Maple St'),
(6, 'Jhansi','Lakshmi','2001-12-30','jhansilakshmi@gmail.com','9999888877','67 gandhi road'),
(7, 'Shankar','Dada','1999-04-19','shankardada@gmail.com','6574655623','45/3 rayachoty'),
(8, 'Kusuma','Anjali','2001-03-31','kusumanjali@gmail.com','1234509876','767 kt road'),
(9, 'Om','Parkash','2004-09-06','omprakash@gmail,com','9987654321','SKD Nagar'),
(10,'Garuda','Reddy','1970-01-31','garudareddy@gmail.com','8467767667','78/2 Tirupati');

insert into Accounts(account_id,customer_id,account_type,balance)
values
(11,3,'savings',100000.00),
(12 ,2,'current' ,25399.59),
(13 ,8, 'zero_balance',20050.64),
(14,5,'zero_balance' , 3000.90),
(15,7 ,'savings',138000.00),
(16, 10 ,'current',324938.00),
(17, 6 ,'current',34567.50),
(18, 9 ,'savings',23000.49),
(19, 4 ,'savings',100000.70),
(20, 1 ,'zero_balance',49500.30);

insert into Transactions(transaction_id ,account_id,transaction_type,amount,transaction_date)
values
(1001,11,'deposit',1000.00,'2024-04-11'),
(1002,12,'withdrawal',500.00,'2024-04-03'),
(1003,13,'deposit',	2000.00,'2024-04-05'),
(1004,14,'withdrawal',1000.00,'2024-04-08'),
(1005,15,'transfer',300.00,'2024-04-10'),
(1006,16,'deposit',	2500.00,'2024-04-05'),
(1007,16,'withdrawal',5000,'2024-04-03'),
(1008,18,'transfer',1300,'2024-04-08'),
(1009,19,'deposit',12000,'2024-04-06'),
(1010,20,'withdrawal',2000,'2024-04-23');