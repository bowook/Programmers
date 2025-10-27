import java.util.*;
import java.util.stream.Collectors;;

class Solution {
    public String solution(String s) {
        List<Integer> strs = Arrays.stream(s.split(" "))
                           .map(Integer::parseInt)
                           .collect(Collectors.toList());
        
        String min = String.valueOf(Collections.min(strs));
        String max = String.valueOf(Collections.max(strs));
        
        return min + " " + max;
    }
}