-- 코드를 입력하세요
SELECT count(ui.user_id) as users
from user_info as ui
where ui.joined between ('2021-01-01') and ('2021-12-31')
and ui.age between 20 and 29