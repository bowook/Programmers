def solution(s):
    stack = ['A']
    for i in s:
        if i == stack[-1]:
            stack.pop()
        else:
            stack.append(i)
    if len(stack) == 1:
        return 1
    else:
        return 0
    