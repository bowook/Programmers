def solution(n, words):
    answer = []
    word_list = [words[0]]
    person = 0
    order = 0
    for i in range(1, len(words)):
        if words[i - 1][-1] != words[i][0] or words[i] in word_list:
            person = (i % n) + 1
            order = (i // n) + 1
            break
        word_list.append(words[i])
    
    answer = [person, order]

    return answer