import java.util.*;

class Solution {
    //완주하지 못한 선수를 반환해야함!
    //동명이인이 있을 수 있음.
    public String solution(final String[] participant, final String[] completion) {
        String answer = "";
        
        Map<String, Integer> mapForParticipant = new HashMap<>();
        for (String person : participant) {
            mapForParticipant.put(person, mapForParticipant.getOrDefault(person, 0) + 1);
        }
        
        for (String person : completion) {
            if (mapForParticipant.containsKey(person)) {
                mapForParticipant.put(person, mapForParticipant.get(person)-1);
            }
        }
        
        for(Map.Entry<String, Integer> entry : mapForParticipant.entrySet()) {
            if (entry.getValue() >= 1) {
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}
