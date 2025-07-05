import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int count = 0;

        Map<Integer, Stack<Integer>> melody = new LinkedHashMap<>();

        for (int i = 1; i <= 6; i++) {
            melody.put(i, new Stack<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int lineNumber = Integer.parseInt(st.nextToken());
            int pNumber = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = melody.get(lineNumber);

            if (stack.isEmpty()) {
                stack.push(pNumber);
                count += 1;
                continue;
            }

            if (stack.peek() < pNumber) {
                stack.push(pNumber);
                count += 1;
                continue;
            }

            if (stack.peek() == pNumber) {
                continue;
            }

            try {
                while (stack.peek() > pNumber) {
                    stack.pop();
                    count += 1;
                }
                if (stack.peek() != pNumber) {
                    stack.push(pNumber);
                    count += 1;
                }
            } catch (EmptyStackException e) {
                stack.push(pNumber);
                count += 1;
            }
        }

        System.out.println(count);
    }
}
