-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from fish_info as fi
where fi.length is NULL
group by fi.length
