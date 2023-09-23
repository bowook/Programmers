def solution(s):
    answer = ''
    stack = list(map(int, s.split(' ')))
    stack.sort()
    answer += str(stack[0])
    answer += ' '
    answer += str(stack[-1])
    return answer