from collections import defaultdict
def solution(numbers, hand):
    #hand는 사용자의 주 손잡이
    # 1 2 3
    # 4 5 6
    # 7 8 9
    # * 0 #
    answer = ''
    phone_num_dict = {1 : [0,0], 2: [0,1], 3:[0,2],
                     4 : [1,0], 5: [1,1], 6:[1,2],
                     7 : [2,0], 8: [2,1], 9:[2,2],
                     '*':[3,0], 0 : [3,1], '#':[3,2]}
    l_now_position = phone_num_dict['*']
    r_now_position = phone_num_dict['#']
    for num in numbers:
        now_position = phone_num_dict[num]
        if num in [1,4,7]:
            answer += "L"
            l_now_position = now_position
        elif num in [3,6,9]:
            answer += "R"
            r_now_position = now_position
        elif num in [2,5,8,0]:
            left_dis : int = 0
            right_dis : int = 0
            for i,j,k in zip(l_now_position,r_now_position,now_position):
                left_dis += abs(i - k)
                right_dis += abs(j - k)
            if left_dis < right_dis:
                answer += "L"
                l_now_position = now_position
            elif right_dis < left_dis:
                answer += "R"
                r_now_position = now_position
            elif left_dis == right_dis:
                if hand == "right":
                    answer += "R"
                    r_now_position = now_position
                elif hand == "left":
                    answer += "L"
                    l_now_position = now_position
            
            
    return answer