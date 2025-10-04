import java.util.*;

class Solution {
    //완주하지 못한 선수를 반환해야함!
    //동명이인이 있을 수 있음.
    public String solution(final String[] participant, final String[] completion) {
        Map<String, Integer> mapForParticipant = new HashMap<>();
        for (String person : participant) {
            mapForParticipant.put(person, mapForParticipant.getOrDefault(person, 0) + 1);
        }
        
        for (String person : completion) {
            mapForParticipant.put(person, mapForParticipant.get(person)-1);
        }
        
        for(Map.Entry<String, Integer> entry : mapForParticipant.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return null;
    }
}
