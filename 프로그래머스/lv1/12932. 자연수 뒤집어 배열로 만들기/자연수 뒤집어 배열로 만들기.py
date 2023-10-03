def solution(n):
    answer = []
    n_temp = list(map(int, str(n)))
    n_temp_len = len(n_temp)
    for i in range(n_temp_len):
        answer.append(n_temp[-1])
        n_temp.pop()
    return answer