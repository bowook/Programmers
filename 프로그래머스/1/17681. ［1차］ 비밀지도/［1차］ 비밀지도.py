def solution(n, arr1, arr2):
    #숫자로 암호화
    #지도는 한변의 길이가 n인 정사각형 배열
    #각 칸은 공백 또는 벽 두 종류
    #1은 벽, 0은 공백
    answer = []
    binary_num_arr1 = []
    binary_num_arr2 = []
    final = []
    for i in range(n):    
        binary_num_arr1.append(format(arr1[i],'b'))
        binary_num_arr2.append(format(arr2[i],'b'))
        binary_num_arr1[i] = ('0' * (n-len(binary_num_arr1[i]))) + binary_num_arr1[i]
        binary_num_arr2[i] = ('0' * (n-len(binary_num_arr2[i]))) + binary_num_arr2[i]
        temp = ''
        for j in range(n):
            if binary_num_arr1[i][j] == '1' or binary_num_arr2[i][j] == '1':
                temp += '#'
            elif binary_num_arr1[i][j] == '0' or binary_num_arr2[i][j] == '0':
                temp += ' '
        final.append(temp)
    return final