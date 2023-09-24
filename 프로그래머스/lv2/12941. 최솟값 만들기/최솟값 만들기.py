def solution(A,B):
    # 단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.
    A.sort()
    B.sort(reverse=True)
    a_plus_b : int = 0
    a_len = len(A)
    for i in range(a_len):
        a_plus_b += A[-1] * B[-1]
        A.pop()
        B.pop()

    return a_plus_b