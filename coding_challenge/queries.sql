use car_rental_system;

select * from vehicle;
select * from payment;
select * from customer;
select * from lease;

-- 1
update vehicle set dailyRate=68.00
where make='Mercedes';

-- 2
delete from Payment where leaseID in(select leaseID from Lease where customerID = 9);
delete from Lease where customerID = 9;
delete from Customer where customerID = 9;

-- 3
ALTER TABLE Payment
CHANGE COLUMN paymentDate transactionDate DATE;

-- 4
select * from customer
where email='sarah@example.com ';

-- 5
select l.leaseID, v.make, v.model, v.year, l.startDate, l.endDate from Lease l
join Vehicle v on l.vehicleID = v.vehicleID
where l.customerID = '4'
and l.endDate >= current_date;

-- 6
select paymentID,transactionDate,amount from payment p
join lease l on p.leaseID = l.leaseID
join customer c on c.customerID=l.customerID
where c.phoneNumber='555-456-7890';

-- 7
select avg(dailyRate) as avg_daily_rate from vehicle where status=1;

-- 8
select max(dailyRate) as highest_dailyrate from vehicle;

-- 9
select v.vehicleID,v.make,v.model from vehicle v
join lease l on l.vehicleID=v.vehicleID
join customer c on c.customerID=l.customerID
where c.customerID='3';

-- 10
select * from lease
where startDate=(select max(startDate) from lease);

-- 11
select * from payment
where year(transactionDate)= 2023;

-- 12
select c.* from customer c
left join lease l on l.customerID =c.customerID
left join payment p on p.leaseID=l.leaseID
where p.paymentID is null;

-- 13
select v.vehicleID,v.make,v.model,sum(p.amount) as total_payments
from Vehicle v
join lease l ON v.vehicleID = l.vehicleID
join payment p ON l.leaseID = p.leaseID
group by v.vehicleID, v.make, v.model;

-- 14
select c.customerID,c.firstName,c.lastName,sum(p.amount) as total_payments
from customer c
join lease l on c.customerID=l.customerID
join payment p on p.leaseID=l.leaseID
group by c.customerID,c.firstName,c.lastName;

-- 15
select l.*,v.make,v.model from lease l
join vehicle v on v.vehicleID=l.vehicleID;

-- 16
select  l.*,
    c.firstName,
    c.lastName,
    c.email,
    C.phoneNumber,
    V.make,
    V.model,
    V.year,
    V.dailyRate,
    V.passengerCapacity,
    V.engineCapacity
from Lease l
join Customer c on l.customerID=c.customerID
join Vehicle v ON l.vehicleID=v.vehicleID
where l.endDate >=curdate();

-- 17
select c.customerID,c.firstName,c.lastName,sum(p.amount) as total_spent
from customer c
join lease l on c.customerID=l.customerID
join payment p on p.leaseID=l.leaseID
group by c.customerID,c.firstName,c.lastName
order by total_spent desc limit 1;

-- 18
select v.*,l.leaseID,l.startDate,l.endDate,l.type,c.firstName,c.lastName,c.email,c.phoneNumber
from vehicle v
left join lease l on v.vehicleID=l.vehicleID
left join customer c on c.customerID=l.customerID;