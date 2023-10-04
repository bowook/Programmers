def solution(num):
    answer = 0
    if num == 1:
        answer = 0
    else:
        while num != 1:
            if num % 2 == 0:
                #짝수
                num = num // 2
                answer += 1
            elif num % 2 == 1:
                #홀수
                num = (num * 3) + 1
                answer += 1
            if answer == 500:
                answer = -1
                return answer
    return answer