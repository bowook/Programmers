import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        //uuid별로 최신 닉네임을 저장함.
        Map<String, String> recordMap = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < record.length; i ++) {
            String[] str = record[i].split(" ");
            String type = str[0];
            String uuid = str[1];
      
            if (type.equals("Enter") || type.equals("Change")) {
                String name = str[2];
                if (!recordMap.containsKey(uuid)) {
                    recordMap.put(uuid, name);
                    deque.addLast(uuid +":"+type);
                }
                else if (recordMap.containsKey(uuid) && !recordMap.get(uuid).equals(name)) {
                    recordMap.put(uuid, name);
                    deque.addLast(uuid +":"+type);
                }
                else if (recordMap.containsKey(uuid) && recordMap.get(uuid).equals(name)) {
                    deque.addLast(uuid +":"+type);
                }
            }
            else if (type.equals("Leave")) {
                deque.addLast(uuid +":"+type);
            }
        }
        int index = 0;
        while (!deque.isEmpty()) {
            String[] strSet = deque.pollFirst().split(":");
            String uuid = strSet[0];
            String type = strSet[1];
            if (type.equals("Change")) {
                continue;
            }
            answer.add(mappingMessage(type, recordMap.get(uuid)));
        }
        return answer.stream().toArray(String[]::new);
    }
    
    private String mappingMessage(String type, String name) {
        if (type.equals("Enter")) {
            return name +"님이 들어왔습니다.";
        }
        return name +"님이 나갔습니다.";
    }
}