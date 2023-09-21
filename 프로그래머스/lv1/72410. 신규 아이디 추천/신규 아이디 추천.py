import re
def solution(new_id):
    #아이디의 길이는 3자이상~15자이하
    #소문자, -, _, ., 만 사용 가능, 단 마침표는 처음과 끝에 사용 불가 + 연속사용 불가
    new_id = new_id.lower() #1단계
    answer = ''
    for i in new_id:
        if i.isdigit():
            continue
        elif i.isdigit() == False:
            #77,78,127, 97, 122
            if ord(i) not in [45,95,46,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,
                          112,113,114,115,116,117,118,119,120,121,122]:
                new_id = new_id.replace(i,'')
    if '.' in new_id:
        new_id = re.sub('\.{2,}', ';', new_id)
    if ';' in new_id:
        new_id = new_id.replace(';', '.')
    if new_id[0] == '.' and new_id[-1] == '.':
        new_id = new_id[1:-1]
    elif new_id[0] == '.':
        new_id=new_id[1:]
    elif new_id[-1] == '.':
        new_id = new_id[:-1]
    if new_id == '':
        new_id += 'a'
    if len(new_id) >= 16:
        new_id = new_id[0:15]
        if new_id[-1] =='.':
            new_id = new_id[0:14]
    elif len(new_id) <= 2:
        temp = new_id[-1]
        while len(new_id) <= 2:
            new_id += temp
            
    return new_id