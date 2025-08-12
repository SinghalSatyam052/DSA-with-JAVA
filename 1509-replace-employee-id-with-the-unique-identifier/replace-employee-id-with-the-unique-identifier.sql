# Write your MySQL query statement below
select euni.unique_id, e.name
from employees e
left join EmployeeUNI euni
on euni.id = e.id;