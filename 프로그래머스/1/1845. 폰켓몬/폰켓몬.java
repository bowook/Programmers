import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pocketmons = init(nums);
        int pickCounts = nums.length / 2;
        
        if (pocketmons.size() > pickCounts) {
            return pickCounts;
        }
        return pocketmons.size();
    }
    
    private Set<Integer> init(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for  (int num : nums) {
            set.add(num);
        }
        
        return set;
    }
}