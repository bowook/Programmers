def solution(N, stages):
    #실패율 = 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
    #전체 스테이지의 개수 N
    #게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
    #실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담긴 배열 return
    #만약에 실패율이 같은 스테이지가 있으면 작은 번호의 스테이지가 먼저 오도록
    answer = []
    final = []
    user_len = len(stages)
    for i in range(N):
        answer.append(i+1)
        if stages.count(answer[-1]) > 0:
            #그러면 반복문하면서 answer에 스테이지 넘버가 들어감
            #그러면 1번스테이지부터 N번 스테이지까 다 들어감
            #그러면 해당 스테이지가 있는지 확인
            #있으면 실패율로 바꿔줌
            temp = answer[-1]
            answer[-1] = stages.count(answer[-1]) / user_len
            #아 user_len이 점점 줄어들어어야 하는군
            user_len -= stages.count(temp)
        else:
            #count가 없다란소리는 해당 스테이지에 있는 사용자가 없는거임!
            answer[-1] = 0
    for i in range(N):
        max_index = answer.index(max(answer))
        answer[max_index] = -999999
        final.append(max_index + 1)
    return final