import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N;  i ++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
                continue;
            }

            Integer value = pq.poll();
            if (value == null) {
                value = 0;
            }
            sb.append(value)
                .append("\n");
        }

        System.out.println(sb);
    }
}