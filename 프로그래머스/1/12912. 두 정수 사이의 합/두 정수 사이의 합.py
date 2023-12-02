def solution(a, b):
    sum : int = 0
    if a > b:
        temp = a
        a = b
        b = temp
    for i in range(a, b+1):
        sum += i
    return sum