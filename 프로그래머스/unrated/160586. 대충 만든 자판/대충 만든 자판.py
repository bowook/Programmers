from collections import defaultdict
def solution(keymap, targets):
    answer = []
    key_num = defaultdict(list)
    for key in keymap:
        for num, value in enumerate(key):
            if key_num[value] == []:
                key_num[value] = num + 1
            elif key_num[value] != [] and num+1 < key_num[value]:
                key_num[value] = num + 1
    for key in targets:
        sum_num : int = 0
        for t in key:
            if key_num[t] == []:
                sum_num = -1
                break
            sum_num += key_num[t]
        answer.append(sum_num)
    return answer