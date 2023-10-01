def solution(nums):
    from itertools import combinations as cb
    answer = []
    real_count : int  = 0
    for i,j,k in cb(nums,3):
        sum_num = i+j+k
        count : int = 0
        print(sum_num)
        for l in range(2, sum_num):
            if sum_num % l == 0:
                #한번이라도 0이 나오면
                count += 1
                #소수가 아니란 소리임
                break
        if count == 0:
            #count가 0이면 소수임
            real_count += 1
    return real_count