import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static boolean foundFlag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());

            heights.add(height);
        }

        dfs(0, 0, 0, heights, new Stack<>());

        System.out.println(sb.toString().trim());
    }

    private static void dfs(int count, int index, int sum, List<Integer> heights, Stack<Integer> stack) {
        if (foundFlag) {
            return;
        }

        if (stack.size() == 7 && sum == 100) {
            List<Integer> found = new ArrayList<>(stack);
            Collections.sort(found);

            for (int height : found) {
                sb.append(height).append("\n");
            }
            foundFlag = true;
            return;
        }

        if (count >= 7 && sum != 100) {
            return;
        }

        if (index >= heights.size()) {
            return;
        }

        //여기에는 이 숫자를 넣은 녀석으로 끝까지 가보는거임
        stack.push(heights.get(index));
        dfs(count + 1, index + 1, sum + heights.get(index), heights, stack);

        //여기서는 넣은거 뽑고
        stack.pop();
        //그 다음꺼부터 끝까지 가봄, 넣은 거 없으니까 count그대로 주고, index는 이동, 기존 sum 가져오고
        dfs(count, index + 1, sum, heights, stack);
    }
}
