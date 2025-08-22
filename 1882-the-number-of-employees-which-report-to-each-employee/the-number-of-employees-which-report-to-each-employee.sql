# Write your MySQL query statement below
SELECT M.employee_id, M.name,COUNT(*) as reports_count, ROUND(AVG(E.age)) as average_age
FROM Employees E JOIN Employees M
ON E.reports_to = M.employee_id
GROUP BY M.employee_id, M.name
ORDER BY M.employee_id;