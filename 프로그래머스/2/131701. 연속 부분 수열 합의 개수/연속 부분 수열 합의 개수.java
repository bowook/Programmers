import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] arr = init(elements);
        for (int length = 1; length <= elements.length; length ++) {
            for (int j = 0; j < elements.length; j ++) {
                int sum = IntStream.range(j, j + length)
                                    .map(index -> arr[index])
                                    .sum();
                
                hashSet.add(sum);
            }
        }
        
        return hashSet.size();
    }
    
    private int[] init(int[] elements) {
        int[] arr = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i ++) {
            arr[i] = elements[i];
            arr[i + elements.length] = elements[i];
        }
        
        return arr;
    }
}