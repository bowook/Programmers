import java.util.*;

class Solution {
    public int solution(final String[][] clothes) {
        Map<String,Integer> wardrobe = new HashMap<>();
        for (int i = 0; i < clothes.length; i ++) {
            String type = clothes[i][1];
        
            wardrobe.put(type, wardrobe.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int count : wardrobe.values()) {
            answer *= (count + 1); // 안 입는 경우까지 포함
        }

        return answer - 1;
    }
}