-- 코드를 작성해주세요
SELECT ed.id,
case when ed.size_of_colony > 1000 then 'HIGH'
     when ed.size_of_colony > 100 then 'MEDIUM'
     else 'LOW'
end as SIZE
from ECOLI_DATA as ed
order by ed.id asc