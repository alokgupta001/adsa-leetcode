# Write your MySQL query statement below
WITH total_users AS (
    SELECT COUNT(*) AS total
    FROM Users
)
SELECT
    contest_id,
    ROUND(COUNT(DISTINCT user_id) * 100 / total, 2) AS percentage
FROM Register
CROSS JOIN total_users
GROUP BY contest_id
ORDER BY percentage DESC, contest_id;