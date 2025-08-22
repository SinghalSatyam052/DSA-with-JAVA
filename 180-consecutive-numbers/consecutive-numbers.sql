# Write your MySQL query statement below
SELECT DISTINCT num as ConsecutiveNums
FROM (
    SELECT num,
    LEAD(num,1) OVER () as n1,
    LEAD(num,2) OVER () as n2
    FROM Logs
) T
WHERE T.num = T.n1 AND T.n1 = T.n2;
    