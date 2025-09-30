-- 코드를 입력하세요
SELECT pt.PT_NAME, pt.PT_NO, pt.GEND_CD, pt.AGE,
case when pt.tlno is null then 'NONE' else pt.tlno end as tlno
from PATIENT pt
where pt.age <= 12 and pt.GEND_CD = 'W'
order by pt.age desc, pt.pt_name asc
