def solution(a, b):
    answer = 0
    days_name = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    days_num = [31, 29, 31, 30, 31, 30,31, 31, 30, 31, 30, 31]
    
    for i in range(a-1):
        answer+=days_num[i]
    answer += b
    answer = answer % len(days_name)
    return days_name[answer-1]