import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(final long n) {
        String[] array = String.valueOf(n).split("");
        
        List<Integer> list = new ArrayList<>();
        for (String str : array) {
            list.add(Integer.parseInt(str));
        }

        Collections.reverse(list);
        
        return list;
    }
}
