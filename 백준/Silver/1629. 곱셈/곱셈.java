import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //    10 11 12
    //11홀수니까
    //10 * (10 ^(11-1)/2) ^ 2 -> 10 * ( 10 ^ 5) ^ 2
    //10 5 12
    //5는 홀수니까
    //10 * (10 ^ (5-1)/2) ^2 -> 10 * (10 ^ 2) ^ 2
    //10 2 12
    //2는 짝수니까
    //(10 ^ 1 ) ^ 2
    //10 1 12
    //1은 홀수니까
    //10 * ( 10 ^ (1-1)/2) ^ 2 -> 10 * (10 ^ 0 ) ^ 2
    //exp == 0이 되면
    //return 1;
    //그러면
    //10 * 1 ^ 2 = 10 % 12 = 10
    //10 ^ 2 = 100 % 12 = 4
    //10 * 16 = 160 % 12 = 4
    //10 * 16 = 160 % 12 = 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int result = modularExponential(A,B,C);
        System.out.println(result);
    }
    private static int modularExponential(int base, int exp, int mod) {
        if(exp == 0) {
            return 1;
        }

        base %= mod;

        if(exp % 2 == 0) {
            // 지수가 짝수인 경우
            int half = modularExponential(base, exp / 2, mod);
            return (int)((long)half * half % mod);
        } else {
            // 지수가 홀수인 경우
            int half = modularExponential(base, (exp - 1) / 2, mod);
            return (int)((long)half * half % mod * base % mod);
        }
    }
}