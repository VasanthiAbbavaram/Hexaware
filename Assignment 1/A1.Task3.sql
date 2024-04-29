use techshop;
SELECT O.OrderID, O.OrderDate, O.TotalAmount, C.FirstName, C.LastName, C.Email, C.Phone, C.Address
FROM Orders O
INNER JOIN Customer C ON O.CustomerID = C.CustomerID;

SELECT P.ProductName, SUM(OD.Quantity * P.Price) AS TotalRevenue
FROM Products P
INNER JOIN OrderDetails OD ON P.ProductID = OD.ProductID
INNER JOIN Orders O ON OD.OrderID = O.OrderID
GROUP BY P.ProductName;

SELECT DISTINCT C.FirstName, C.LastName, C.Email, C.Phone, C.Address
FROM Customer C
INNER JOIN Orders O ON C.CustomerID = O.CustomerID;

SELECT P.ProductName, SUM(OD.Quantity) AS TotalQuantityOrdered
FROM Products P
JOIN OrderDetails OD ON P.ProductID = OD.ProductID
GROUP BY P.ProductName
ORDER BY TotalQuantityOrdered DESC
LIMIT 1;

SELECT c.FirstName, c.LastName, AVG(o.TotalAmount) AS AvgOrderValue
FROM Customer c
JOIN Orders o ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID;

SELECT o.OrderID, c.FirstName, c.LastName, c.Email, c.Phone, c.Address, MAX(o.TotalAmount) AS TotalRevenue
FROM Orders o
JOIN Customer c ON o.CustomerID = c.CustomerID;

SELECT p.ProductName, SUM(od.Quantity) AS TotalOrders
FROM OrderDetails od
JOIN Products p ON od.ProductID = p.ProductID
GROUP BY p.ProductName;

SELECT c.FirstName, c.LastName, c.Email, c.Phone, c.Address
FROM Customer c
JOIN Orders o ON c.CustomerID = o.CustomerID
JOIN OrderDetails od ON o.OrderID = od.OrderID
JOIN Products p ON od.ProductID = p.ProductID
WHERE p.ProductName = 'Widget C'; 

select * from products;

select * from orders;

SELECT SUM(o.TotalAmount) AS TotalRevenue
FROM Orders o
WHERE o.OrderDate BETWEEN '2024-04-01' AND '2024-04-30'; 