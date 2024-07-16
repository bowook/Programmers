import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < T; i ++) {
            String arr = scanner.nextLine();
            String result = pushAndPop(arr);

            System.out.println(result);
        }
    }

    public static String pushAndPop(String arr) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i <arr.length(); i ++) {
            if(arr.charAt(i) == '(') {
                stack.push(arr.charAt(i));
            }
            else if(arr.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}