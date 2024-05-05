import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> tempArray = new ArrayList<>();
        tempArray.add(arr[0]);
        int tempIndex = 1;
        for(int i = 1; i < arr.length; i ++) {
            if(tempArray.get(tempIndex-1) == arr[i]) {
                continue;
            }
            else {
                tempArray.add(arr[i]);
                tempIndex += 1;
            }
        }
        answer = tempArray.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}