def solution(s):
    answer = ''
    s_len = len(s)
    first_index : int = 0
    for i in range(s_len):
        if s[i] == ' ':
            answer += ' '
            first_index = 0
        elif first_index % 2 == 0:
            answer += s[i].upper()
            first_index += 1
        elif first_index % 2 != 0:
            answer += s[i].lower()
            first_index += 1
            
        
    return answer