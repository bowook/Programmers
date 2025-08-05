import java.util.*;
import java.io.*;

class Solution {
    private static final String ODD = "Odd";
    private static final String EVEN = "Even";
    
    public String solution(final int num) {
        if (num % 2 == 0) {
            return EVEN;
        }
        
        return ODD;
    }
}