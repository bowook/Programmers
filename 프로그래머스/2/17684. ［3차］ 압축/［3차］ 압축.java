//사전에 추가되지 않은 현재 글자까지를 현재 입력이라고 봄

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = init();
        List<Integer> answer = new ArrayList<>();
        //인덱스 탐색 하면 안되고, 포인트를 이동시켜야 함.
        int left = 0;
        while (left < msg.length()) {
            String read = "";
            int right = left;
            
            //현재 에서 읽을 수 있는 가장 긴 문자열을 찾아야함
            while (right < msg.length()) {
                String current = msg.substring(left, right + 1);
                if (dictionary.containsKey(current)) {
                    read = current;
                    right ++;
                    continue;
                }
                break;
            }
            //읽을 수 있는 긴 문자열을 찾았음.
            answer.add(dictionary.get(read));
            if (right < msg.length()) {
                String next = msg.substring(left, right + 1);
                dictionary.put(next, dictionary.size() + 1);
            }
            left += read.length();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private Map<String, Integer> init() {
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 1; i <= 26; i ++) {
            dictionary.put(String.valueOf((char)('A' + i - 1)), i);
        }
        
        return dictionary;
    }
}