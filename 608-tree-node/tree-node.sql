with recursive cte as(select id, p_id from Tree where p_id is null
union all
select t.id,t.p_id from tree t join cte  c on t.p_id=c.id) select id ,case when p_id is null then"Root" when id in (select p_id from tree where p_id is not null) then "Inner" else "Leaf" end as type from cte order by id;
		