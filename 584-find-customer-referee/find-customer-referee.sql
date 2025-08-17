# Write your MySQL query statement below
SELECT name 
FROM customer
WHERE referee_id <> 2 OR isnull(referee_id);