def solution(n):
    temp : int = 1
    while n % temp != 1:
        temp += 1
    return temp