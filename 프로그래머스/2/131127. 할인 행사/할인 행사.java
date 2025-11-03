// 10일 동안 회원 자격 부여
// 회원을 대상, 매일, 한 가지, 제품 할인
// 할인하는 제품은 하루에, 하나씩만 구매 가능
// 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속 일치할 경우 회원가입 하려고 함.

import java.util.*;

class Solution {
    
    private static final int TEN_DAYS = 10;
    
    public int solution(String[] wants, int[] numbers, String[] discounts) {
        Map<String, Integer> wantsMap = init(wants, numbers);
        Map<String, Integer> tenDaysMap = initTenDays(discounts);
        
        
        //원하는 것을 다 샀는지 먼저 판단해야함.
        int answer = 0;
        if (isMatch(wantsMap, tenDaysMap)) {
            answer += 1;
        }
        
        //다음날부터 진행
        for (int i = 10; i < discounts.length; i++) {
            String removed = discounts[i - TEN_DAYS];
            String added = discounts[i];
            
            tenDaysMap.put(removed, tenDaysMap.get(removed) - 1);
            tenDaysMap.put(added, tenDaysMap.getOrDefault(added, 0) + 1);
            if (isMatch(wantsMap, tenDaysMap)) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    private boolean isMatch(Map<String,Integer> wantsMap, Map<String,Integer> discountsMap) {
        for(Map.Entry<String, Integer> entry : discountsMap.entrySet()) {
            String name = entry.getKey();
            int counts = entry.getValue();
            
            if (wantsMap.getOrDefault(name, 0) != counts) {
                return false;
            }
            continue;
        }
        
        return true;
    }
    
    private Map<String, Integer> initTenDays(String[] discounts) {
        Map<String, Integer> firstTenDaysMap = new HashMap<>();
        for (int i = 0; i < TEN_DAYS; i ++) {
            String discount = discounts[i];
            
            firstTenDaysMap.put(discount, firstTenDaysMap.getOrDefault(discount,0) +1);
        }
        
        return firstTenDaysMap;
    }
    
    private Map<String, Integer> init(String[] wants, int[] numbers) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wants.length; i ++) {
            String want = wants[i];
            int number = numbers[i];
            
            map.put(want, number);
        }
        
        return map;
    }
}