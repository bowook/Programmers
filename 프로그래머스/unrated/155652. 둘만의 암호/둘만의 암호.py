def solution(s, skip, index):
    #문자열 s, skip
    #자연수 index
    #97 ~ 122
    answer = ''
    for alphabet in s:
        stack = []
        temp = ord(alphabet) + 1
        if temp > 122:
            temp = temp - 26
        while len(stack) < index:
            if chr(temp) not in skip:
                stack.append(chr(temp))
                temp += 1
                if temp > 122:
                    temp = temp - 26
            elif chr(temp) in skip:
                temp += 1
                if temp > 122:
                    temp = temp - 26
        answer += stack[-1]
    return answer