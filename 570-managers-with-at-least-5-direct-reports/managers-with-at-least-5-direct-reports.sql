WITH cte AS (
    SELECT
        a.id,
        a.name,
        COUNT(*) AS reports
    FROM Employee a
    JOIN Employee b
        ON a.id = b.managerId
    GROUP BY a.id, a.name
)
SELECT name
FROM cte
WHERE reports >= 5;