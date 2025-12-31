import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        System.out.println(z(size, r, c));
    }

    private static int z(int n, int r, int c) {
        if (n == 1) {
            return 0;
        }

        int half = n / 2;
        int area = half * half;
        
        if (r < half && c < half) {
            // 2사분면
            return z(half, r, c);
        }
        else if (r < half && c >= half) {
            // 1사분면
            return area + z(half, r, c - half);
        }
        else if (r >= half && c < half) {
            // 3사분면
            return 2 * area + z(half, r - half, c);
        }
        else {
            // 4사분면
            return 3 * area + z(half, r - half, c - half);
        }
    }
}
