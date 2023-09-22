def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
     #중복삭제
    for i in lost[:]:
        if i in reserve:
            lost.remove(i)
            reserve.remove(i)
    #여유분있는애들이 줘야함

    for i in reserve:
        if i-1 in lost:
            lost.remove(i-1)
        elif i+1 in lost:
            lost.remove(i+1)

    return n-len(lost)