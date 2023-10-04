def solution(n):
    answer = list(map(int, str(n)))
    answer.sort()
    answer.sort(reverse=True)
    temp = ''
    for i in range(len(answer)):
        temp += str(answer[i])
    return int(temp)