def solution(babbling):
    # "aya", "ye", "woo", "ma" 
    babblig_list = ["aya", "ye", "woo", "ma"]
    stack = []
    for i in babbling:
        for j in babblig_list:
            if j*2 not in i:
                i = i.replace(j,' ')
        if i.isspace():
            stack.append(1)
    return sum(stack)