def solution(babbling):
    bab_dict = ['aya', 'ye','woo','ma']
    stack = []
    for i in babbling:
        for j in bab_dict:
            if j * 2 not in i:
                #연속으로 나오는게 i에 없다면
                i = i.replace(j, " ")
        
        if i.isspace():
            stack.append(1)

    return len(stack)