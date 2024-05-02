drop database if exists Asset_Management;
create database Asset_Management;
use Asset_Management;

drop table if exists employees;
drop table if exists assets;
drop table if exists maintenance_records;
drop table if exists asset_allocations;
drop table if exists reservations;

create table employees(
	employee_id int Primary Key,
	name varchar(20),
	department varchar(20),
	email varchar(20),
	password varchar(10)
);
desc employees;

create table assets(
	asset_id int Primary Key,
	name varchar(20),
	type varchar(20),
	serial_number int,
	purchase_date date,
	location varchar(20),
	status varchar(20),
	owner_id int,
    foreign key(owner_id ) references employees(employee_id)
);
desc assets;

create table maintenance_records(
	maintenance_id int primary key,
	asset_id int,
	maintenance_date date,
	description text,
	cost decimal(10,2),
    foreign key(asset_id) references assets(asset_id)
);
desc maintenance_records;

create table asset_allocations(
	 allocation_id int primary key,
     asset_id int,
     employee_id int,
     allocation_date date,
     return_date date,
     foreign key(asset_id) references assets(asset_id),
     foreign key(employee_id) references employees(employee_id)
);
desc asset_allocations;

create table reservations(
	reservation_id int primary key,
    asset_id int,
    employee_id int,
    reservation_date date,
    start_date date,
    end_date date,
    status varchar(20),
    foreign key(asset_id) references assets(asset_id),
    foreign key(employee_id) references employees(employee_id)
);
desc reservations;

use asset_management;
insert into employees (employee_id, name, department, email, password)  
values (1, 'John Doe', 'HR', 'john@example.com', 'pass123'),
(2, 'Jane Smith', 'Marketing', 'jane@example.com', 'pass456'),
(3, 'Michael Johnson', 'Finance', 'michael@example.com', 'pass789'),
(4, 'Emily Brown', 'IT', 'emily@example.com', 'passabc'),
(5, 'David Lee', 'Operations', 'david@example.com', 'passdef'),
(6, 'Sarah Taylor', 'HR', 'sarah@example.com', 'passghi'),
(7, 'Kevin Clark', 'Marketing', 'kevin@example.com', 'passjkl'),
(8, 'Jessica Martinez', 'Finance', 'jessica@example.com', 'passmno'),
(9, 'Andrew Wilson', 'IT', 'andrew@example.com', 'passpqr'),
(10, 'Jennifer Anderson', 'Operations', 'jennifer@example.com', 'passtu'),
(11, 'Daniel Brown', 'HR', 'daniel@example.com', 'passvwx'),
(12, 'Olivia Johnson', 'Marketing', 'olivia@example.com', 'passyz'),
(13, 'Matthew Davis', 'Finance', 'matthew@example.com', 'pass1234'),
(14, 'Emma Wilson', 'IT', 'emma@example.com', 'pass5678'),
(15, 'James Taylor', 'Operations', 'james@example.com', 'pass91011');

insert into assets (asset_id, name, type, serial_number, purchase_date, location, status, owner_id) values
(1, 'Laptop', 'Electronic', 123456, '2024-01-15', 'Office A', 'Active', 1),
(2, 'Printer', 'Office Equipment', 789012, '2023-12-20', 'Office B', 'Active', 2),
(3, 'Desk', 'Furniture', 345678, '2024-02-10', 'Office C', 'In Use', 3),
(4, 'Chair', 'Furniture', 901234, '2024-03-05', 'Office A', 'In Use', 4),
(5, 'Monitor', 'Electronic', 567890, '2024-01-30', 'Office D', 'Active', 5),
(6, 'Scanner', 'Office Equipment', 123789, '2024-02-20', 'Office B', 'Active', 6),
(7, 'Phone', 'Electronic', 456789, '2024-03-10', 'Office C', 'In Use', 7),
(8, 'Projector', 'Office Equipment', 890123, '2023-12-05', 'Office A', 'Active', 8),
(9, 'Table', 'Furniture', 234567, '2024-01-25', 'Office D', 'In Use', 9),
(10, 'Desktop', 'Electronic', 678901, '2024-02-15', 'Office B', 'Active', 10),
(11, 'Cabinet', 'Furniture', 345678, '2024-03-20', 'Office C', 'In Use', 11),
(12, 'Fax Machine', 'Office Equipment', 789012, '2024-01-10', 'Office A', 'Active', 12),
(13, 'Server', 'Electronic', 567890, '2023-12-15', 'Office D', 'Active', 13),
(14, 'Filing Cabinet', 'Furniture', 123789, '2024-02-05', 'Office B', 'In Use', 14),
(15, 'Router', 'Electronic', 456789, '2024-03-30', 'Office C', 'Active', 15);

insert into maintenance_records (maintenance_id, asset_id, maintenance_date, description, cost) values
(1, 1, '2024-02-05', 'Replaced battery', 50.00),
(2, 2, '2024-01-20', 'Cleaned printhead', 30.00),
(3, 3, '2024-03-10', 'Adjusted height', 20.00),
(4, 4, '2024-02-15', 'Tightened screws', 15.00),
(5, 5, '2024-01-30', 'Calibrated colors', 40.00),
(6, 6, '2024-03-05', 'Updated firmware', 25.00),
(7, 7, '2024-02-20', 'Replaced damaged screen', 100.00),
(8, 8, '2024-01-25', 'Cleaned lens', 10.00),
(9, 9, '2024-03-15', 'Polished surface', 15.00),
(10, 10, '2024-02-10', 'Installed software update', 30.00),
(11, 11, '2024-01-15', 'Reinforced hinges', 20.00),
(12, 12, '2024-03-20', 'Replaced paper feeder', 50.00),
(13, 13, '2024-02-05', 'Upgraded RAM', 80.00),
(14, 14, '2024-01-10', 'Repaired drawer', 25.00),
(15, 15, '2024-03-25', 'Reset configuration', 35.00);

insert into asset_allocations (allocation_id, asset_id, employee_id, allocation_date, return_date) values
(1, 1, 1, '2024-01-10', '2024-01-15'),
(2, 2, 2, '2024-01-15', '2024-01-20'),
(3, 3, 3, '2024-01-20', '2024-01-25'),
(4, 4, 4, '2024-01-25', '2024-01-30'),
(5, 5, 5, '2024-01-30', '2024-02-05'),
(6, 6, 6, '2024-02-05', '2024-02-10'),
(7, 7, 7, '2024-02-10', '2024-02-15'),
(8, 8, 8, '2024-02-15', '2024-02-20'),
(9, 9, 9, '2024-02-20', '2024-02-25'),
(10, 10, 10, '2024-02-25', '2024-03-01'),
(11, 11, 11, '2024-03-01', '2024-03-06'),
(12, 12, 12, '2024-03-06', '2024-03-11'),
(13, 13, 13, '2024-03-11', '2024-03-16'),
(14, 14, 14, '2024-03-16', '2024-03-21'),
(15, 15, 15, '2024-03-21', '2024-03-26');

insert into reservations (reservation_id, asset_id, employee_id, reservation_date, start_date, end_date, status) values
(1, 1, 1, '2024-01-05', '2024-01-10', '2024-01-15', 'Confirmed'),
(2, 2, 2, '2024-01-10', '2024-01-15', '2024-01-20', 'Confirmed'),
(3, 3, 3, '2024-01-15', '2024-01-20', '2024-01-25', 'Confirmed'),
(4, 4, 4, '2024-01-20', '2024-01-25', '2024-01-30', 'NotConfirmed'),
(5, 5, 5, '2024-01-25', '2024-01-30', '2024-02-05', 'Confirmed'),
(6, 6, 6, '2024-01-30', '2024-02-05', '2024-02-10', 'Confirmed'),
(7, 7, 7, '2024-02-05', '2024-02-10', '2024-02-15', 'NotConfirmed'),
(8, 8, 8, '2024-02-10', '2024-02-15', '2024-02-20', 'NotConfirmed'),
(9, 9, 9, '2024-02-15', '2024-02-20', '2024-02-25', 'Confirmed'),
(10, 10, 10, '2024-02-20', '2024-02-25', '2024-03-01', 'Confirmed'),
(11, 11, 11, '2024-02-25', '2024-03-01', '2024-03-06', 'NotConfirmed'),
(12, 12, 12, '2024-03-01', '2024-03-06', '2024-03-11', 'Confirmed'),
(13, 13, 13, '2024-03-06', '2024-03-11', '2024-03-16', 'NotConfirmed'),
(14, 14, 14, '2024-03-11', '2024-03-16', '2024-03-21', 'null'),
(15, 15, 15, '2024-03-16', '2024-03-21', '2024-03-26', 'NotConfirmed');
