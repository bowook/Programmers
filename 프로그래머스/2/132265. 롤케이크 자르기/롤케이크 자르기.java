// 각 조각에 동일한 가짓수의 토핑이 올라가면 공평한 것
// a 조각에 4 종류의 토핑, b 조각에 4 종류의 토핑이면 공평한 것
import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        //자르는 포인트를 바꾸는거네
        int answer = 0;
        //일단 다 내꺼
        Map<Integer, Integer> mine = new HashMap<>();
        for (int topping : toppings) {
            mine.put(topping, mine.getOrDefault(topping, 0) + 1);
        }
        
        //나눠줌
        Set<Integer> your = new HashSet<>();
        for (int topping : toppings) {
            your.add(topping);
            mine.put(topping, mine.get(topping) - 1);
            
            if (mine.get(topping) == 0) {
                mine.remove(topping);
            }
            
            if (mine.size() == your.size()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
