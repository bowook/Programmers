def solution(n):
    #n은 2이상
    stack = [0,1]
    temp = 0
    while len(stack) <= n:
        stack.append(stack[-1]+stack[-2])

    return stack[-1] % 1234567