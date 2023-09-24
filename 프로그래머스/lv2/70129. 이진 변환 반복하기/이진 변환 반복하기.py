def solution(s):
    answer = [1,s.count('0')]
    s = s.replace('0','')
    s_len = len(s)
    while s_len // 2 > 0 :
        binaryNum = format(s_len, 'b')
        answer[1] += binaryNum.count('0')
        answer[0] += 1
        binaryNum = binaryNum.replace('0','')
        s_len = len(binaryNum)

    return answer