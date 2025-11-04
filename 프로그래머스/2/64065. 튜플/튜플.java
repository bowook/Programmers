//원소의 개수가 n개, 중복되는 원소가 없음, 
import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "/");
        String[] sets = s.split("/");
        Arrays.sort(sets, (a, b) -> a.length() - b.length());
        
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        for (String set : sets) {
            String[] splittedSets = set.split(",");
            for (String splittedSet : splittedSets) {
                hashSet.add(Integer.parseInt(splittedSet));
            }
        }
        
        return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }
}