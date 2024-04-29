use hmbank;
-- 1. Write a SQL query to Find the average account balance for all customers.
select avg(balance) as Average_bal from accounts;

 -- 2. Write a SQL query to Retrieve the top 10 highest account balances.
 select customer_id,balance from accounts
 order by balance desc
 limit 10;
 
 -- 3. Write a SQL query to Calculate Total Deposits for All Customers in specific date.
 select sum(amount)  as total_deposit from Transactions
 where transaction_type='deposit'
 and Transaction_date ='2024-04-11';
 
 -- 4. Write a SQL query to Find the Oldest and Newest Customers.
 select customer_id,first_name,last_name,DOB from customers
 order by DOB asc
 limit 1;
 
 select customer_id,first_name,last_name,DOB from customers 
 order by DOB desc
 limit 1;
 
 -- 5. Write a SQL query to Retrieve transaction details along with the account type.
select transactions.transaction_id,transactions.account_id,accounts.account_type,transactions.transaction_type,transactions.transaction_date,transactions.amount
from transactions
join accounts on transactions.account_id=accounts.account_id;

-- 6. Write a SQL query to Get a list of customers along with their account details
select accounts.account_id,concat(customers.first_name,' ',customers.last_name) as Name,accounts.account_type,accounts.balance
from accounts
join customers on customers.customer_id=accounts.customer_id;

-- 7. Write a SQL query to Retrieve transaction details along with customer information for a specific account
use hmbank;
select t.transaction_id, t.account_id, a.customer_id, c.first_name, c.last_name,  t.transaction_type, t.amount, t.transaction_date,c.DOB, c.email, c.phone_number, c.address from transactions t
join accounts a on t.account_id=a.account_id
join customers c on c.customer_id=a.customer_id
where a.account_id=19;

-- 8. Write a SQL query to Identify customers who have more than one account.
select c.customer_id, c.first_name, c.last_name, count(a.account_id) from customers c
join accounts a on c.customer_id=a.customer_id
group by c.customer_id, c.first_name, c.last_name
having count(a.account_id)>1 ;

-- 9. Write a SQL query to Calculate the difference in transaction amounts between deposits and withdrawals.
select ((select sum(amount) from transactions where transaction_type='deposit')-(select sum(amount) from transactions where transaction_type='withdrawal'))
as difference;

-- 10. Write a SQL query to Calculate the average daily balance for each account over a specified period
SELECT account_id, AVG(balance) AS average_daily_balance
FROM (
    SELECT account_id, transaction_date, 
           SUM(CASE WHEN transaction_type = 'deposit' THEN amount ELSE -amount END) AS balance
    FROM Transactions
    WHERE transaction_date BETWEEN '2024-04-02' AND '2024-04-30'
    GROUP BY account_id, transaction_date
) AS daily_balances
GROUP BY account_id;

-- 11. Calculate the total balance for each account type.
select account_type,sum(balance)
from accounts
group by account_type;

-- 12. Identify accounts with the highest number of transactions order by descending order
select a.account_id,count(t.transaction_type) as transaction_count
from accounts a
inner join transactions t on a.account_id=t.account_id
group by a.account_id
order by transaction_count desc;

-- 13. List customers with high aggregate account balances, along with their account types
select c.customer_id,c.first_name,c.last_name,a.account_type,sum(a.balance) as tot_balance
from customers as c
inner join accounts as a on a.customer_id=c.customer_id
group by c.customer_id, c.first_name, c.last_name, a.account_type
order by tot_balance desc;

-- 14. Identify and list duplicate transactions based on transaction amount, date, and account.
select transaction_id,account_id,transaction_type,amount,transaction_date,count(*) as duplicate_count
from transactions
group by transaction_id, account_id, transaction_type, amount, transaction_date
having count(*)>1;


