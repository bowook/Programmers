import math
def solution(n):
    answer = n ** 0.5
    answer_temp = int(math.sqrt(n))
    if answer == answer_temp:
        answer = (answer + 1) ** 2
    else:
        answer = -1
    return answer