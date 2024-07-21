import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //스택에 push하는 순서는 반드시 오름차순
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] inputSequence = new int[n];
        for(int i = 0; i < n; i++) {
            inputSequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        int currentNumber = 1;

        for (int i = 0; i < n; i++) {
            int targetNum = inputSequence[i];

            // 현재 숫자가 목표 숫자보다 작거나 같으면 스택에 푸시
            while (currentNumber <= targetNum) {
                stack.push(currentNumber);
                output.append("+\n");
                currentNumber++;
            }

            // 목표 숫자를 스택에서 팝
            if (!stack.isEmpty() && stack.peek() == targetNum) {
                stack.pop();
                output.append("-\n");
            } else {
                // 목표 숫자가 스택의 최상단이 아닐 경우
                output.setLength(0); // 출력 초기화
                output.append("NO\n");
                break;
            }
        }

        System.out.println(output);

    }
}