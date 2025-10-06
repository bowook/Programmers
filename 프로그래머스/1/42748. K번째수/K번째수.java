import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandsLength = commands.length;
        int[] answer = new int[commandsLength];
        
        for (int index = 0; index < commandsLength; index ++) {
            int[] command = commands[index];
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;
            
            List<Integer> subNumbers = new ArrayList<>();
            for (int idx = i; idx <= j; idx ++) {
                subNumbers.add(array[idx]);
            }
            Collections.sort(subNumbers);
            
            answer[index] = subNumbers.get(k);
        }
        
        return answer;
    }
}