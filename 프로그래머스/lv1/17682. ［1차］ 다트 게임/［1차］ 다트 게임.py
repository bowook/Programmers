def solution(dartResult):
    stack = []
    dartResult = dartResult.replace("10","A")
    score = {'S':1, 'D' : 2, 'T' : 3}
    for i in dartResult:
        if i.isdigit() or i == 'A':
            stack.append(10 if i == 'A' else int(i))
        elif i in score:
            score_temp = stack.pop()
            stack.append(score_temp ** score[i])
        elif i == '*':
            score_temp = stack.pop()
            if stack:
                stack[-1] *= 2
            stack.append(score_temp * 2)
        elif i == '#':
            score_temp = stack.pop()
            stack.append(score_temp * -1)
    return sum(stack)
            
                