import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<>();
        
        int temp = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                //나눠짐
                list.add(arr[i]);
            }
        }
        if(list.size()==0) {
            list.add(-1);
        }
        
        int[] answer = new int[list.size()];
        
        // Collections.sort(list);
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        for(int i = 0; i < answer.length; i++) {
            for(int j = i+1; j < answer.length; j++) {
                if (answer[i] > answer[j]) {
                    temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        return answer;
    }
}