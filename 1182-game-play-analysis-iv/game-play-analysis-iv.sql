# Write your MySQL query statement below
SELECT ROUND(SUM(login)/COUNT(DISTINCT player_id),2) fraction
FROM(
    SELECT player_id, DATEDIFF(event_date,MIN(event_date)
    OVER (PARTITION BY player_id)) = 1 as login
    FROM activity
) t;