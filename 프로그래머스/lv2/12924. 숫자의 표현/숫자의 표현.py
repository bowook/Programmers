def solution(n):
    count : int = 0
    for i in range(1, n+1):
        temp = i
        n_sum : int = 0
        while True:
            n_sum += temp
            temp += 1
            if n_sum == n:
                count += 1
            elif n_sum > n:
                break      
    return count