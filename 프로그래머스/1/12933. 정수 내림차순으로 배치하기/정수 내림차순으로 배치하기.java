import java.util.*;

class Solution {
    public long solution(final long n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(new String(chars)).reverse();
        
        return Long.parseLong(sb.toString());
    }
}