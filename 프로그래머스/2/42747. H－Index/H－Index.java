import java.util.*;

class Solution {
    
    public int solution(final int[] citations) {
        List<Integer> reverseOrderedCitations = sortReverse(citations);
        
        return findHIndex(reverseOrderedCitations);
    }
    
    private int findHIndex(final List<Integer> reverseOrderedCitations) {
        int hIndex = 0;
        for (int i = 0; i < reverseOrderedCitations.size(); i ++) {
            int quotationCounts = reverseOrderedCitations.get(i);
            if (quotationCounts > hIndex) {
                hIndex += 1;
                continue;
            }
        }
        
        return hIndex;
    }
    
    private List<Integer> sortReverse(final int[] citations) {
        Arrays.sort(citations);
        List<Integer> reverseOrderedCitations = new ArrayList<>();
        for (int i = citations.length - 1; i >= 0; i --) {
            reverseOrderedCitations.add(citations[i]);
        }
        
        return reverseOrderedCitations;
    }
}