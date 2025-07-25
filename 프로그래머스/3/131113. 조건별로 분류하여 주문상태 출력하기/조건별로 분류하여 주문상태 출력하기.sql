SELECT
ORDER_ID
, PRODUCT_ID
, DATE_FORMAT(OUT_DATE, '%Y-%m-%d')
, IF (OUT_DATE <= '2022-05-01', '출고완료', IF (OUT_DATE IS NULL, '출고미정', '출고대기')) AS '출고여부'
FROM
FOOD_ORDER
ORDER BY ORDER_ID ASC