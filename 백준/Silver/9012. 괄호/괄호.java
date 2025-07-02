import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            char[] brackets = br.readLine().toCharArray();
            if (isVPS(0, brackets, 0)) {
                sb.append(YES).append("\n");
                continue;
            }
            sb.append(NO).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    private static boolean isVPS(int index, char[] brackets, int count) {
        if (count < 0) {
            return false;
        }

        if (index == brackets.length && count == 0) {
            //같을 때에 true를 반환해야하는 경우도 있어서 위에서 count <0 과 함께 한번에 false를 처리하면 안 됨.
            return true;
        } else if (index == brackets.length) {
            return false;
        }

        char bracket = brackets[index];

        if (bracket == '(') {
            return isVPS(index + 1, brackets, count + 1);
        }
        return isVPS(index + 1, brackets, count - 1);
    }
}
