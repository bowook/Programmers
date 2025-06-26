import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int position = 1;

        int changedNumber = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(position);
        for (int i = 0; i < changedNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (stack.contains(X)) {
                stack.pop();
                stack.push(Y);
            } else if (stack.contains(Y)) {
                stack.pop();
                stack.push(X);
            }
        }

        System.out.println(stack.peek());
    }
}
