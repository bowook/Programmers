import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] afterRanking = new int[N];
        int[] ranks = new int[N];
        int maxRankValue = Integer.MIN_VALUE;
        
        HashMap<Integer, Integer> positionMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            positionMap.put(number, i + 1); 
        }
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            afterRanking[i] = Integer.parseInt(st.nextToken());
            int originalPosition = positionMap.get(afterRanking[i]);
            int newPosition = i + 1; // 1-based index
            int rank = originalPosition - newPosition;
            ranks[i] = rank;
            
            if (maxRankValue < rank) {
                maxRankValue = rank;
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (ranks[i] == maxRankValue) {
                sb.append(afterRanking[i]).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}