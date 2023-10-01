def solution(cards1, cards2, goal):
    cards1_len = len(cards1)
    cards2_len = len(cards2)
    for i in range(1, cards1_len):
        if cards1[i] in goal:
            if cards1[i-1] not in goal:
                return "No"
            elif goal.index(cards1[i-1]) > goal.index(cards1[i]):
                return "No"
    for i in range(1, cards2_len):
        if cards2[i] in goal:
            if cards2[i-1] not in goal:
                return "No"
            elif goal.index(cards2[i-1]) > goal.index(cards2[i]):
                return "No"
            
        
    return "Yes"