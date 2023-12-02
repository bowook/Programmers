def solution(s):
    answer = True
    p_count : int = 0
    y_count : int = 0
    for i in s:
        if i == 'p' or i == 'P':
            p_count +=1
        elif i == 'y' or i == 'Y':
            y_count +=1
    
    if p_count == y_count:
        answer = True
    else:
        answer = False
    return answer