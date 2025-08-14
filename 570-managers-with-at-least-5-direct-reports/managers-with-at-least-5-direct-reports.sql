# Write your MySQL query statement below
SELECT e.name FROM Employee e
JOIN 
    (
        SELECT managerId FROM Employee
        GROUP BY managerId
        HAVING COUNT(managerId) > 4
    ) t
WHERE e.id = t.managerId;