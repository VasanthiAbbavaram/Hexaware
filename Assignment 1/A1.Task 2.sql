-- 1. Write an SQL query to retrieve the names and emails of all customers.
use techshop;
select FirstName,LastName,Email from customer;

-- 2. Write an SQL query to list all orders with their order dates and corresponding customer names.
use techshop;
select orders.OrderID,orders.OrderDate,CustomerID from orders;

-- 3. Write an SQL query to insert a new customer record into the "Customers" table. Include customer information such as name, email, and address.
use techshop;
insert into customer(CustomerID,FirstName,LastName,Email,Phone,Address)
values(11,'Shoban','Shetty','shobanshetty@gmail.com','6501452367','19-2 Newyork');


-- 4. Write an SQL query to update the prices of all electronic gadgets in the "Products" table by increasing them by 10%.
use techshop;
update products set Price=Price*1.1;

-- 5. Write an SQL query to delete a specific order and its associated order details from the "Orders" and "OrderDetails" tables. Allow users to input the order ID as a parameter

DELETE FROM OrderDetails WHERE OrderID = 4;
DELETE FROM Orders WHERE OrderID = 4;


-- 6. Write an SQL query to insert a new order into the "Orders" table. Include the customer ID, order date, and any other necessary information.
insert into orders(OrderID,CustomerID,OrderDate,TotalAmount)
values(12,'14','2024-04-25',100.50);

-- 7. Write an SQL query to update the contact information (e.g., email and address) of a specific customer in the "Customers" table. A
update customer set Phone=9087766541
where CustomerID=1;

select * from orders;

-- 8. Write an SQL query to recalculate and update the total cost of each order in the "Orders" table based on the prices and quantities in the "OrderDetails" table
UPDATE Orders
SET TotalAmount = (
    SELECT SUM(od.Quantity * p.Price) FROM OrderDetails od
    INNER JOIN Products p ON od.ProductID = p.ProductID
    WHERE od.OrderID = Orders.OrderID
    GROUP BY od.OrderID
);

-- 9
DELETE FROM OrderDetails WHERE OrderID IN (SELECT OrderID FROM Orders WHERE CustomerID = @CustomerID);
DELETE FROM Orders WHERE CustomerID = 1;

-- 10
INSERT INTO Products (productID,ProductName, Description, Price)
VALUES (11,'New Gadget', 'A unique widget', 99.99);
