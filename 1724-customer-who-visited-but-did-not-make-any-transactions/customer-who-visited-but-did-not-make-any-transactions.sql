# Write your MySQL query statement below
SELECT v.customer_id, count(*) as count_no_trans
FROM visits v LEFT JOIN transactions t
ON v.visit_id = t.visit_id
WHERE ISnull(t.transaction_id)
GROUP BY customer_id;