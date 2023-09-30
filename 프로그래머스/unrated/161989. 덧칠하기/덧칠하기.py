def solution(n, m, section):
    count : int = 1
    start_point = section[0]
    section_len = len(section)
    for i in range(1, section_len):
        if section[i] - start_point >= m :
            count += 1
            start_point = section[i]
    return count