-- 코드를 입력하세요
SELECT b.book_id, date_format(b.published_date, '%Y-%m-%d') as published_date
FROM book as b
where b.published_date between ('2021-01-01') and ('2021-12-31')
and b.category = '인문'
order by b.published_date asc