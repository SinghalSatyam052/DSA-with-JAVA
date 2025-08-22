# Write your MySQL query statement below
SELECT e1.employee_id, e1.department_id
FROM Employee e1
JOIN (
    SELECT employee_id, COUNT(department_id) as cnt
    FROM Employee
    GROUP BY employee_id
) e2
ON e1.employee_id = e2.employee_id
WHERE e2.cnt = 1
OR e1.primary_flag = 'Y';