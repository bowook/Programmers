import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else { // ch == )
                stack.pop(); // 일단 ( 하나 제거

                if (input.charAt(i - 1) == '(') {
                    // 레이저
                    count += stack.size();
                } else {
                    // 쇠막대기 끝
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}
