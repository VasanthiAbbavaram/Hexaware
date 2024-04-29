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

INSERT INTO Customer(CustomerID, FirstName, LastName, Email, Phone, Address)
VALUES 
(1, 'John', 'Doe', 'john.doe@gmail.com', '1234567890', '123 Main St'),
(2, 'Jane', 'Smith', 'jane.smith@mail.com', '9876543210', '456 Elm St'),
(3, 'Alice', 'Johnson', 'alice.johnson@mail.com', '5551234567', '789 Oak St'),
(4, 'Bob', 'Williams', 'bob.williams@mail.com', '9876543210', '321 Pine St'),
(5, 'Emily', 'Brown', 'emily.brown@mail.com', '5559876543', '654 Maple St'),
(6, 'Jhansi','Lakshmi','jhansilakshmi@gmail.com','9999888877','67 gandhi road'),
(7, 'Shankar','Dada','shankardada@gmail.com','6574655623','45/3 rayachoty'),
(8, 'Kusuma','Anjali','kusumanjali@gmail.com','1234509876','767 kt road'),
(9, 'Om','Parkash','omprakash@gmail,com','9987654321','SKD Nagar'),
(10,'Garuda','Reddy','garudareddy@gmail.com','8467767667','78/2 Tirupati');

INSERT INTO Products (ProductID, ProductName, Description, Price)
VALUES 
(1, 'Widget A', 'A basic widget', 10.99),
(2, 'Widget B', 'An advanced widget', 15.99),
(3, 'Widget C', 'A premium widget', 20.99),
(4, 'Widget D', 'A deluxe widget', 25.99),
(5, 'Widget E', 'A high-end widget', 30.99),
(6, 'Widget F', 'An exclusive widget', 35.99),
(7, 'Widget G', 'A specialized widget', 40.99),
(8, 'Widget H', 'A unique widget', 45.99),
(9, 'Widget I', 'A customized widget', 50.99),
(10, 'Widget J', 'A versatile widget', 55.99);

INSERT INTO Orders (OrderID, CustomerID, OrderDate, TotalAmount)
VALUES 
(1, 1, '2024-04-25', 50.97),
(2, 2, '2024-04-26', 62.97),
(3, 3, '2024-04-27', 31.98),
(4, 4, '2024-04-28', 77.97),
(5, 5, '2024-04-29', 135.96),
(6, 6, '2024-04-30', 167.95),
(7, 7, '2024-05-01', 220.94),
(8, 8, '2024-05-02', 180.93),
(9, 9, '2024-05-03', 153.92),
(10, 10, '2024-05-04', 279.91);

INSERT INTO OrderDetails (OrderDetailID, OrderID, ProductID, Quantity)
VALUES 
(1, 1, 1, 2),
(2, 1, 3, 1),
(3, 2, 2, 3),
(4, 2, 4, 2),
(5, 3, 1, 1),
(6, 3, 2, 1),
(7, 4, 3, 2),
(8, 4, 4, 3),
(9, 5, 4, 1),
(10, 5, 5, 4);

INSERT INTO Inventory (InventoryID, ProductID, QuantityInStock, LastStockUpdate)
VALUES 
(1, 1, 100, '2024-04-24'),
(2, 2, 150, '2024-04-25'),
(3, 3, 75, '2024-04-05'),
(4, 4, 200, '2024-04-25'),
(5, 5, 50, '2024-04-23'),
(6, 6, 80, '2024-04-25'),
(7, 7, 120, '2024-03-01'),
(8, 8, 90, '2024-04-25'),
(9, 9, 110, '2024-04-02'),
(10, 10, 70, '2024-04-12');
