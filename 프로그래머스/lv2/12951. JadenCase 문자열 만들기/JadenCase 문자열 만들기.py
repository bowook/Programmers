def solution(s):
    words = s.split(' ')
    len_words = len(words)
    for i in range(len_words):
        words[i] = words[i].capitalize()
        
    answer = ' '.join(words)
    
    return answer