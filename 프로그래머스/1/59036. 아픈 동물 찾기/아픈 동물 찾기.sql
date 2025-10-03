-- 코드를 입력하세요
SELECT ai.animal_id, ai.name
from animal_ins as ai
where ai.intake_condition = 'sick'
order by ai.animal_id asc