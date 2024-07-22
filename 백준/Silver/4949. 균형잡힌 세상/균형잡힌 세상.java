import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(true) {
            input = br.readLine();
            boolean isTrue = true;
            if (input.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < input.length(); i ++) {
                if(input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                }
                else if(input.charAt(i) == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        isTrue = false;
                        break;
                    }
                    else if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        isTrue = true;
                    }
                }
                else if(input.charAt(i) == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        isTrue = false;
                        break;
                    }
                    else if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        isTrue = true;
                    }
                }
            }

            if(isTrue && stack.isEmpty()) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}