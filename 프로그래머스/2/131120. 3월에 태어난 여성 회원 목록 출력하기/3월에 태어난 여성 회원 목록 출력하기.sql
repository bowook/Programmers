-- 코드를 입력하세요
SELECT mp.member_id, mp.member_name, mp.gender, date_format(mp.date_of_birth, '%Y-%m-%d') as date_of_birth
from member_profile as mp
where mp.date_of_birth = date_format(mp.date_of_birth, '%Y-03-%d')
and mp.gender = 'W'
and mp.TLNO is not null
order by mp.member_id asc