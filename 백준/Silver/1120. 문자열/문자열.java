import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int aLength = A.length();
        int bLength = B.length();
        int gap = bLength - aLength;

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i <= gap; i++) {
            int distance = 0;
            for (int j = i; j < aLength + i; j++) {
                char aChar = A.charAt(j - i);
                char bChar = B.charAt(j);

                if (aChar == bChar) {
                    continue;
                }
                distance++;
            }

            if (distance < minDistance) {
                minDistance = distance;
            }
        }

        System.out.println(minDistance);
    }
}
