import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int counts = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        hanoi(K, 1, 2, 3);
        System.out.println(counts);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            counts += 1;
            return;
        }

        hanoi(n-1, start, to, mid);
        sb.append(start + " " + to + "\n");
        counts += 1;
        hanoi(n-1, mid, start, to);
    }
}
