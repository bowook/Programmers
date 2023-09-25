import math
#약수는 대칭적인 관계니까, 굳이 끝까지 탐색할 필요 없이 중간까지만 봐도됨
def solution(brown, yellow):
    total = brown + yellow
    total_middle = int(math.sqrt(total)) + 1
    for i in range(1, total_middle):
        if total % i == 0:
            width = total // i
            height = i
            if (width - 2) * (height - 2) == yellow:
                return [width, height]
