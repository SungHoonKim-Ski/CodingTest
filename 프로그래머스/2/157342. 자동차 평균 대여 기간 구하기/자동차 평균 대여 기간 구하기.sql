# -- 코드를 입력하세요
# SELECT
# CAR_ID
# , ROUND(AVG(END_DATE - START_DATE + 1), 1) AS AVERAGE_DURATION
# FROM
# CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY
# CAR_ID
# HAVING AVG(END_DATE - START_DATE + 1) >= 7
# ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

SELECT 
car_id
, ROUND(AVG(DATEDIFF(end_date, start_date) + 1), 1) as average_duration
FROM car_rental_company_rental_history
GROUP BY car_id
HAVING AVG(DATEDIFF(end_date, start_date) + 1) >= 7
ORDER BY average_duration DESC, car_id DESC;