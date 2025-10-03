-- 코드를 입력하세요
SELECT os.user_id, os.product_id
from online_sale as os
group by os.user_id, os.product_id
having count(os.product_id) > 1
order by os.user_id asc, os.product_id desc