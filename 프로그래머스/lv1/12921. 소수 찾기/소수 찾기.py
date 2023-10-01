def solution(n):
    import math
    prime_arr = [True] * (n+1)
    prime_arr[0] = [False]
    prime_arr[1] = [False]
    for i in range(2, int(math.sqrt(n)+1)):
        if prime_arr[i] == True:
            j = 2
            while ( i * j ) <= n:
                prime_arr[i*j] = False
                j += 1
    return prime_arr.count(True)
            
                    
                