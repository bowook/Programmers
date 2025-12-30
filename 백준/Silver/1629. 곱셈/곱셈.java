import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        long result = calculate(A, B, C);
        System.out.println(result);
    }
    
    private static long calculate(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        long half = calculate(a, b/2, c);
        long temp = (half * half) % c;
        if (b % 2 == 0) {
            return temp;
        }
        else {
            return ((a % c) * temp) % c;
        }
    }
}
