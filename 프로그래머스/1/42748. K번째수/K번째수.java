import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            .mapToInt(command -> {
                int i = command[0];
                int j = command[1];
                int k = command[2];
                
                int[] copiedArray = Arrays.copyOfRange(array, i-1, j);
                Arrays.sort(copiedArray);
                
                return copiedArray[k-1];
            })
            .toArray();
    }
}