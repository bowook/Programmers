def solution(numbers):
    sum : int = 0
    for i in range(10):
        if i not in numbers:
            sum += i
    return sum