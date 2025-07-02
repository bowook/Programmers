import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] brackets = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            for (String bracket : brackets) {
                if (bracket.equals("(")) {
                    stack.push(bracket);
                } else if (!stack.isEmpty() && bracket.equals(")")) {
                    stack.pop();
                } else if (stack.isEmpty() && bracket.equals(")")) {
                    stack.push(bracket);
                    break;
                }
            }

            if (stack.isEmpty()) {
                sb.append(YES).append("\n");
                continue;
            }
            sb.append(NO).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
