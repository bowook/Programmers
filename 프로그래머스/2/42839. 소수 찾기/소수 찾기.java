import java.util.*;

class Solution {
    HashSet<Integer> hashSet = new HashSet<>();
    boolean[] visited;
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        visited = new boolean[arr.length];
        dfs(arr, "", 0);
        
        System.out.println(hashSet);
        return hashSet.size();
    }
    
    private void dfs(String[] arr, String number, int depth) {
        if (number.length() > arr.length) {
            return;
        }
        if (!number.isEmpty()) {
            parsePrime(Integer.parseInt(number));
        }
        
        for (int i = 0; i < arr.length; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, number + arr[i], depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private void parsePrime(int number) {
        if (number == 0 || number == 1) {
            return;
        }
        
        if (hashSet.contains(number)) {
            return;
        }
        
        for (int i = 2; i * i <= number; i ++) {
            if (number % i == 0) {
                return;
            }
        }
        
        hashSet.add(number);
    }
}