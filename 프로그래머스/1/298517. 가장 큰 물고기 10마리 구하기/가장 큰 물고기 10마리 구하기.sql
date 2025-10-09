-- 코드를 작성해주세요
select fi.id as ID, fi.length as LENGTH
from fish_info as fi
order by fi.length desc
limit 10

