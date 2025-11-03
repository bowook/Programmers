import java.util.*;

class Solution {
    
    public int solution(int[] citations) {
        List<Integer> reverseList = sortReverse(citations);
        int h = 0;
        for (int i = 0; i < reverseList.size(); i ++) {
            int value = reverseList.get(i);
            if (value >= i + 1) {
                h += 1;
            }
        }
        return h;
    }
    
    private List<Integer> sortReverse(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for (int citation : citations) {
            list.add(citation);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        return list;
    }
}