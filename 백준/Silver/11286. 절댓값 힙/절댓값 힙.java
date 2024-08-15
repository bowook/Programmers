import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(
                (n1,n2) -> {
                    if (Math.abs(n1) == Math.abs(n2)) {
                        return n1 > n2 ? 1 : -1;
                    } else {
                        return Math.abs(n1) - Math.abs(n2);
                    }

            }
        );
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            int number = Integer.parseInt(br.readLine());

            if(number == 0) {
                if(!absHeap.isEmpty()) {
                    sb.append(absHeap.poll()).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
                continue;
            }
            absHeap.offer(number);

        }

        System.out.println(sb);
    }
}