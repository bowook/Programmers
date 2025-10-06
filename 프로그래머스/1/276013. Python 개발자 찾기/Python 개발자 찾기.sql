-- 코드를 작성해주세요
SELECT di.id, di.email, di.first_name, di.last_name
from DEVELOPER_INFOS as di
where 'Python' in (di.skill_1, di.skill_2, di.skill_3)
order by di.id asc