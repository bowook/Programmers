def solution(nums):
    nums_len = len(nums)//2
    nums = set(nums)
    if len(nums) == nums_len:
        return len(nums)
    elif len(nums) > nums_len:
        return nums_len
    elif len(nums) < nums_len:
        return len(nums)
    return 