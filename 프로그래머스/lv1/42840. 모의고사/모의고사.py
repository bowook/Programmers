def solution(answers):
    answers_len = len(answers)
    score = [0,0,0]
    first_std = [1,2,3,4,5] * answers_len
    second_std = [2,1,2,3,2,4,2,5] * answers_len
    third_std = [3,3,1,1,2,2,4,4,5,5] * answers_len
    for index, value in enumerate(answers):
        if answers[index] ==  first_std[index]:
            score[0] += 1
        if answers[index] == second_std[index]:
            score[1] += 1
        if answers[index] == third_std[index]:
            score[2] += 1
    if score.count(max(score)) == 3:
        score = [1, 2, 3]
    elif score.count(max(score)) == 2:
        if max(score) == score[0] and max(score) == score[1]:
            score = [1,2]
        elif max(score) == score[0] and max(score) == score[2]:
            score = [1,3]
        elif max(score) == score[1] and max(score) == score[2]:
            score = [2,3]
    elif score.count(max(score)) == 1:
        if max(score) == score[0]:
            score = [1]
        elif max(score) == score[1]:
            score = [2]
        else:
            score = [3]
            
            
    return score 