# Write your MySQL query statement below
SELECT MAX(num) AS num
FROM (
    SELECT num, COUNT(*) cnt
    FROM MyNumbers
    GROUP BY num
) t
WHERE cnt = 1;