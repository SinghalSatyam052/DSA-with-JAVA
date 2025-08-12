SELECT max(salary) AS SecondHighestSalary
FROM 
(
    SELECT salary, dense_rank() 
    OVER (ORDER BY salary desc) as rnk
    FROM employee
) AS ranked
WHERE rnk = 2;

