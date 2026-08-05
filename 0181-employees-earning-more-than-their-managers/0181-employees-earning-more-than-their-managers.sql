# Write your MySQL query statement below
SELECT e.name AS Employee from Employee e where e.managerId IS NOT NULL and salary>(select salary from Employee m where m.id = e.managerId);