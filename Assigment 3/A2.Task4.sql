-- 1. Retrieve the customer(s) with the highest account balance.
select  c.customer_id,
    c.first_name,
    c.last_name,
    c.email,
    c.phone_number,
    c.address,
    a.balance
from customers c
join accounts a on a.customer_id=c.customer_id
where a.balance=(select max(balance) from accounts);

-- 2. Calculate the average account balance for customers who have more than one account
select avg(total_balance) as avg_account_balance
from(
	select avg(balance) as total_balance from accounts
    where customer_id in(
		select customer_id from accounts
        group by customer_id
        having count(*)>1
    )
    group by customer_id
)as subquery;

-- 3. Retrieve accounts with transactions whose amounts exceed the average transaction amount
select a.account_id, a.customer_id, a.account_type, a.balance, t.transaction_id, t.transaction_type, t.amount, t.transaction_date
from Accounts a
join Transactions t on a.account_id = t.account_id
where t.amount > (select avg(amount) from Transactions);

-- 4. Identify customers who have no recorded transactions


select c.customer_id, c.first_name, c.last_name
from Customers c
left join Accounts a on c.customer_id = a.customer_id
left join Transactions t on a.account_id = t.account_id
where t.transaction_id is null;

-- 5. Calculate the total balance of accounts with no recorded transactions.
select sum(a.balance) as total_balance_no_transactions
from Accounts a
left join Transactions t on a.account_id = t.account_id
where t.transaction_id is null;

-- 6. Retrieve transactions for accounts with the lowest balance.
select t.*
from Transactions t
join (
    select a.account_id
    from Accounts a
    where a.balance = (
        select MIN(balance)
        from Accounts
    )
) lowest_balance_accounts on t.account_id = lowest_balance_accounts.account_id;

-- 7. Identify customers who have accounts of multiple types
select customer_id
from Accounts
group by customer_id
having count(distinct account_type) > 0;

-- 8. Calculate the percentage of each account type out of the total number of accounts
select account_type, count(*) * 100.0 / (select count(*) from Accounts) as percentage
from Accounts
group by account_type;

-- 9. Retrieve all transactions for a customer with a given customer_id.
select t.*
from Transactions t
join Accounts a on t.account_id = a.account_id
where a.customer_id = '10';

-- 10. Calculate the total balance for each account type, including a subquery within the SELECT clause
select account_type, 
    (select sum(balance) 
     from Accounts a 
     where a.account_type = outer_query.account_type) as total_balance
from (select distinct account_type from Accounts) as outer_query;
