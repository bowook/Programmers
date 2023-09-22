from collections import defaultdict
def solution(players, callings):
    players_dict = {value : key for key, value in enumerate(players)}
    for i in callings:
        idx = players_dict[i]
        players_dict[i] -= 1
        players_dict[players[idx-1]] += 1
        
        players[idx-1] , players[idx] = players[idx], players[idx-1]
    return players