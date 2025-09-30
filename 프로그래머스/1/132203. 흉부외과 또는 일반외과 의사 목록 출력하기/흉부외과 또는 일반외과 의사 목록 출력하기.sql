-- 코드를 입력하세요
SELECT dr.DR_NAME, dr.DR_ID, dr.MCDP_CD, date_format(dr.HIRE_YMD, '%Y-%m-%d')
from doctor dr
where dr.MCDP_CD = 'CS' or dr.MCDP_CD ='GS'
order by dr.HIRE_YMD desc, dr.DR_NAME asc