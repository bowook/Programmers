import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        int boomLen = boom.length;

        StringBuilder sb = new StringBuilder();

        for (char c : input) {
            sb.append(c);
            if (sb.length() >= boomLen) {
                boolean isBoom = true;
                for (int j = 0; j < boomLen; j++) {
                    if (sb.charAt(sb.length() - boomLen + j) != boom[j]) {
                        isBoom = false;
                        break;
                    }
                }
                if (isBoom) {
                    sb.delete(sb.length() - boomLen, sb.length());
                }
            }
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
