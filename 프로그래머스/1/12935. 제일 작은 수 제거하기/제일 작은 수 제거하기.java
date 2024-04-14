import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        int[] answer = {};
        int min = arr[0];
        
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] <= min) {
                min = arr[i];
            }
            temp.add(arr[i]);
        }
        
        while (temp.remove(Integer.valueOf(min))) {        };

        if(temp.size() == 0){
            temp.add(-1);
            answer = new int[1];
            answer[0] = -1;
        }
        else if (temp.size() != 0) {
            answer = new int[temp.size()];
            // Collections.sort(temp, Collections.reverseOrder());
            for(int i = 0; i < temp.size(); i ++) {
                answer[i] = temp.get(i);
            }
        }

        return answer;
    }
}