# Write your MySQL query statement below
SELECT t.id FROM
    (
        SELECT id , temperature, recordDate,
        LAG(temperature) over (ORDER BY recordDate) as prevTemp,
        LAG(recordDate) over (ORDER BY recordDate) as prevdate
        FROM weather
    ) t
WHERE t.temperature > t.prevtemp
AND DATEDIFF (t.recordDate,t.prevdate) = 1;