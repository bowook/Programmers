import collections


def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    print(list(answer.keys())[0])
    return list(answer.keys())[0]