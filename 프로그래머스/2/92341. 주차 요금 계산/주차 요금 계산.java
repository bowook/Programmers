import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitPerMinute = fees[2];
        int feePerUnit = fees[3];
        
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String type = parts[2];
            
            int minutes = timeToMinutes(time);
            
            if (type.equals("IN")) {
                inMap.put(carNumber, minutes);
            } else {
                int inTime = inMap.get(carNumber);
                int parkingTime = minutes - inTime;
                
                totalTimeMap.put(carNumber, 
                    totalTimeMap.getOrDefault(carNumber, 0) + parkingTime);
                
                inMap.remove(carNumber);
            }
        }
        
        int endTime = timeToMinutes("23:59");
        for (String carNumber : inMap.keySet()) {
            int parkingTime = endTime - inMap.get(carNumber);
            totalTimeMap.put(carNumber, 
                totalTimeMap.getOrDefault(carNumber, 0) + parkingTime);
        }
        
        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);
        
        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalTime = totalTimeMap.get(carNumber);
            
            int fee = basicFee;
            if (totalTime > basicTime) {
                int overTime = totalTime - basicTime;
                fee += (int) Math.ceil((double) overTime / unitPerMinute) * feePerUnit;
            }
            answer[i] = fee;
        }
        
        return answer;
    }
    
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}