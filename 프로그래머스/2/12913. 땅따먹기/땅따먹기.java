import java.util.*;

class Solution {
    
    int solution(int[][] land) {
        for (int row = 1; row < land.length; row ++) {
            for (int col = 0; col < 4; col ++) {
                int max = 0;
                for (int before = 0; before < 4; before ++) {
                    if (before != col) {
                        max = Math.max(max, land[row - 1][before]);
                    }
                }
                land[row][col] += max;
            }
        }
        int answer = Math.max(Math.max(land[land.length - 1][0], land[land.length -1][1]), Math.max(land[land.length -1][2], land[land.length -1][3]));
            
        return answer;
    }
}