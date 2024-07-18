import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[last + 1]; // 소수가 아닌 수를 표시할 배열
        isNotPrime[0] = isNotPrime[1] = true; // 0과 1은 소수가 아니므로 true로 설정


        for (int i = 2; i * i <= last; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= last; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }


        for (int i = start; i <= last; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }
}