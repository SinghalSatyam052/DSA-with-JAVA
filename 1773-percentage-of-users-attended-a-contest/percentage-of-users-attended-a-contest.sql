# Write your MySQL query statement below

SELECT r.contest_id, ROUND(((COUNT(DISTINCT(r.user_id))/(SELECT COUNT(user_id) cr FROM users))*100),2) percentage
FROM register r
GROUP BY r.contest_id
ORDER BY percentage DESC,r.contest_id;