def solution(k, m, score):
    score.sort()
    answer = []
    sum : int = 0
    while len(score) >= m :
        answer = []
        for i in range(m):
            answer.append(score[-1])
            score.pop()
        sum += answer[-1] * m
    return sum