from collections import Counter

def solution(X, Y):
    counter_Y = Counter(Y)
    stack = []
    for i in X:
        if counter_Y[i] > 0:
            stack.append(i)
            counter_Y[i] -= 1
    if len(stack) == 0:
        return '-1'
    elif stack[0] == '0':
        return '0'
    else:
        stack.sort(reverse=True)
        return ''.join(stack)
