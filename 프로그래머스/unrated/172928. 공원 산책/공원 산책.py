def solution(park, routes):
    # 'S'의 위치 찾기
    for row in range(len(park)):
        for column in range(len(park[row])):
            if park[row][column] == 'S':
                answer = [row, column]
                break
        else:
            continue
        break

    # 방향에 따른 움직임
    moves = {'E': (0, 1), 'W': (0, -1), 'N': (-1, 0), 'S': (1, 0)}

    def can_move(r, c):
        #주어진 위치가 유효한지 확인
        return 0 <= r < len(park) and 0 <= c < len(park[0]) and park[r][c] != "X"

    for route in routes:
        direction = route[0]
        temp = int(route[2])
        
        dr, dc = moves[direction]
        
        if all(can_move(answer[0] + dr*i , answer[1] + dc*i) for i in range(1,temp+1)):
            answer[0] += dr * temp
            answer[1] += dc * temp

    return answer