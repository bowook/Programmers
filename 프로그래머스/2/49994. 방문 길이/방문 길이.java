import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        Map<String, int[]> map = new HashMap<>();
        map.put("U", new int[]{1,0});
        map.put("D", new int[]{-1,0});
        map.put("R", new int[]{0,1});
        map.put("L", new int[]{0,-1});
        
        Set<String> set = new HashSet<>();
        String[] dirArr = dirs.split("");
        int[] currentPosition = new int[]{0,0};
        for (String dir : dirArr) {
            int[] direction = map.get(dir);
            int newRow = currentPosition[0] + direction[0];
            int newCol = currentPosition[1] + direction[1];
            
            if (newRow >= -5 && newRow <= 5 && newCol >= -5 && newCol <= 5) {
                set.add(currentPosition[0] + "," + currentPosition[1] + "->" + newRow + "," + newCol);
                set.add(newRow + "," + newCol + "->" + currentPosition[0] + "," + currentPosition[1]);
                currentPosition[0] = newRow;
                currentPosition[1] = newCol;
            }
        }

        return set.size() / 2;
    }
}