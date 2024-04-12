import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                //나눠짐
                list.add(arr[i]);
            }
        }
        if(list.size()==0) {
            list.add(-1);
        }
        int[] temp = new int[list.size()];
        Collections.sort(list);
        
        for(int i = 0; i < temp.length; i++) {
            temp[i] = list.get(i);
        }
        return temp;
    }
}