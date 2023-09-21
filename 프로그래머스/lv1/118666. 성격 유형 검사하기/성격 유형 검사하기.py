def solution(survey, choices):
    answer = ''
    survey_dict = {'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    for index, value in enumerate(survey):
        first = value[0]
        second = value[1]
        choice = choices[index]
        if choice < 4:
            if choice == 1:
                survey_dict[first] += 3
            elif choice == 2:
                survey_dict[first] += 2
            elif choice == 3:
                survey_dict[first] += 1
        elif choice > 4:
            if choice == 5:
                survey_dict[second] += 1
            elif choice == 6:
                survey_dict[second] += 2
            elif choice == 7:
                survey_dict[second] += 3   

    keys_list = list(survey_dict.keys())
    print(keys_list)
    
    for i in range(0, len(keys_list), 2):
        #keys_list의 길이는 무조건 8
        key_1, key_2 = keys_list[i], keys_list[i+1]

        if survey_dict[key_1] > survey_dict[key_2]:
            answer += key_1
        elif survey_dict[key_1] < survey_dict[key_2]:
            answer += key_2
        else: #같을경우
            answer += min(key_1,key_2)        
    return answer 