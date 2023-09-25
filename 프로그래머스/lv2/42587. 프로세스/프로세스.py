def solution(priorities, location):
    from collections import deque
    #실행 대기 큐에서 대기중인 프로세스 하나 꺼내기
    #큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가있다면 꺼낸거 다시 넣기
    #그런게 없다면 꺼내서 실행시키기, 실행한 프로세스는 다시 큐에 안넣고 종료
    
    #프로세스의 우선순위가 담긴 배열 priorities, 숫자가 클수록 우선순위가 높음
    #몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location
    temp_queue = [(index,value) for index, value in enumerate(priorities)]
    queue = deque(temp_queue)
    result:int = 0
    while True:
        current_pos = queue.popleft()
        if any(current_pos[1] < q[1] for q in queue):
            #큰게 있니? 있으면 실행
            queue.append(current_pos)
        else:
            #큰게 없니? 없으면 실행
            result += 1
            if current_pos[0] == location:
                return result