# Write your MySQL query statement below
with cte as(
    select a1.machine_id, (a2.timestamp - a1.timestamp)  as time_taken from Activity a1 join Activity a2 on a1.machine_id = a2.machine_id && a1.process_id = a2.process_id && a1.activity_type = 'start' && a2.activity_type = 'end'
)
select machine_id , round(avg(time_taken),3) as processing_time from cte group by machine_id;