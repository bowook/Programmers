def solution(lottos, win_nums):
    answer = []
    zero_count : int = 0
    real_count : int = 0
    lotto_score = {6 : 1, 5 : 2, 4 : 3, 3: 4, 2:5, 1: 6, 0:6}
    for i in lottos:
        if i in win_nums:
            real_count += 1
        elif i == 0:
            zero_count += 1
    return lotto_score[zero_count + real_count], lotto_score[real_count]