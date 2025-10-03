-- 코드를 입력하세요
SELECT round(avg(crcc.daily_fee), 0) as average_fee
from car_rental_company_car as crcc
where crcc.car_type = 'SUV'
