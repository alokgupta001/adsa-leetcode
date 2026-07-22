# Write your MySQL query statement below
with cte as(
    select t1.machine_id, t2.timestamp - t1.timestamp as timetaken from Activity t1 join Activity t2 on t1.process_id = t2.process_id and t1.machine_id = t2.machine_id and t1.activity_type = 'start' and t2.activity_type= 'end'
)
select machine_id , round(sum(timetaken)/count(*),3) as processing_time from cte group by machine_id;