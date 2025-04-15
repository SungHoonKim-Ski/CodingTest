-- 코드를 작성해주세요
SELECT
    A.ID
    , COUNT(B.PARENT_ID) AS CHILD_COUNT
FROM ECOLI_DATA A
LEFT JOIN ECOLI_DATA B ON A.ID = B.PARENT_ID
GROUP BY A.ID
ORDER BY A.ID

# select a.id, count(b.parentid) as childcount
# from ecolidata a left join ecolidata b on a.id = b.parent_id
# group by 1
# order by 1