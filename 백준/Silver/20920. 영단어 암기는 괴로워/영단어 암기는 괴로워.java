import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> {
                    if (!e1.getValue().equals(e2.getValue())) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                    if (e1.getKey().length() != e2.getKey().length()) {
                        return e2.getKey().length() - e1.getKey().length();
                    }
                    return e1.getKey().compareTo(e2.getKey());
                }
        );

        pq.addAll(hashMap.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().getKey()).append("\n");
        }
        System.out.println(sb);
    }
}