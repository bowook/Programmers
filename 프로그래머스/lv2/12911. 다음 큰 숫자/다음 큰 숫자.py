def solution(n):
    binary_n_one_cnt = format(n,'b').count('1')
    while True:
        n = n+1
        binary_next_one_cnt = format(n,'b').count('1')
        if binary_n_one_cnt == binary_next_one_cnt:
            return n