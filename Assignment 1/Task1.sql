drop database if exists Techshop;
create database Techshop;
use Techshop;

DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS OrderDetails;
DROP TABLE IF EXISTS Inventory;

Create Table Customer
(
     CustomerID INT,
	 FirstName varchar(30),
     LastName varchar(30),
     Email varchar(100),
     Phone varchar(20),
     Address varchar(255),
     primary key(CustomerID)
);
desc Customer;

CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(255),
    Description TEXT,
    Price DECIMAL(10, 2)
);
desc Products;

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);
desc Orders;

create table OrderDetails
(
	OrderDetailID INT PRIMARY KEY,
    OrderID int,
    ProductID int,
    Quantity int,
    foreign key(OrderID) references Orders(OrderID),
    foreign key(ProductID) references products(productID)
);
desc OrderDetails;

create table Inventory
(
	InventoryID int primary key,
    ProductID int,
    QuantityInStock int ,
    LastStockUpdate date,
    foreign key(ProductID) references Products(ProductID)
);
desc Inventory;