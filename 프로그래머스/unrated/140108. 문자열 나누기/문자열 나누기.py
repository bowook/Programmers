from collections import deque
def solution(s):
    answer : int = 0
    s_queue = deque(s)
    s_queue_first = list(s_queue)[0]
    flag = False
    same_word_cnt : int = 0
    diff_word_cnt : int = 0
    for index, value in enumerate(list(s_queue)[:]):
        if flag:
            s_queue_first = list(s_queue)[0]
        if s_queue_first == value:
            same_word_cnt +=1
            flag = False
        elif s_queue_first != value:
            diff_word_cnt += 1
            flag = False
        if same_word_cnt == diff_word_cnt:
            flag = True
            for i in range(same_word_cnt + diff_word_cnt):
                s_queue.popleft()
            same_word_cnt = 0
            diff_word_cnt = 0
            answer += 1
    if s_queue:
        return answer + 1
    return answer