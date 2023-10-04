def solution(x):
    x_str_version = str(x)
    x_str_sum : int = 0
    for i in x_str_version:
        x_str_sum += int(i)
    if x % x_str_sum == 0:
        answer = True
    else:
        answer = False
    return answer