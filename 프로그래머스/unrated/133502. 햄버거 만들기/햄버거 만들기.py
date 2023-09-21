def solution(ingredient):
    #1 - 2 - 3 - 1 -> 햄버거 1개
    answer = 0
    stack = []
    for i in ingredient:
        stack.append(i)
        if stack[-4:] == [1,2,3,1]:
            answer += 1
            for i in range(4):
                stack.pop()
    return answer