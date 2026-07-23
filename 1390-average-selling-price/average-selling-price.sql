# Write your MySQL query statement below
with cte as (
    select t1.product_id,t1.price*t2.units as total_price, t2.units from Prices t1 left join UnitsSold t2 on (t1.product_id = t2.product_id and t2.purchase_date>=t1.start_date and t2.purchase_date<=t1.end_date)
)
select product_id, ROUND(ifnull(SUM(total_price) / SUM(units),0), 2)  as average_price from cte group by product_id;