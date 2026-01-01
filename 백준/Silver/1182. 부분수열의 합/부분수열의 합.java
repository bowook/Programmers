import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] numbers;
    private static int S;
    private static int counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        calculate(0, 0);
        if (S == 0) {
            counts --;
        }
        System.out.println(counts);
    }

    private static void calculate(int index, int sum) {
        if (index == numbers.length) {
            if (sum == S) {
                counts ++;
            }
            return;
        }

        calculate(index + 1, sum + numbers[index]);
        calculate(index + 1, sum);
    }
}