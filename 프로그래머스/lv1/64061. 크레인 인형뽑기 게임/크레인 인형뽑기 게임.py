def solution(board, moves):
    #격자 상태가 담긴 2차원 배열 board
    #크레인을 작동시킨 위치가 담긴 배열 moves
    #터트려져 사라진 인형의 개수를 return
    #[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
    #파란색 고양이 : 1
    #노란색 고양이 : 2
    #초록색 고양이 : 3
    #분홍색 복숭아 : 4
    #브라운 강아지 : 5
    stack = []
    answer : int = 0
    for i in moves:
        j = i-1
        #j는 열임
        for k in range(len(board[j])):
            #0열이니까 무조건 len은 5임
            #그러면 k는 0부터 탐색
            if board[k][j] == 0:
                continue
            elif board[k][j] != 0:
                stack.append(board[k][j])
                board[k][j] = 0
                if len(stack) >= 2 and stack[-1] == stack[-2]:
                    answer += 2
                    stack.pop()
                    stack.pop()
                break
        if len(stack) >= 2 and stack[-1] == stack[-2]:
            answer += 2
            stack.pop()
            stack.pop()
    return answer