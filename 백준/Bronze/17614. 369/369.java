import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int clapCount = 0;
        for(int i = 1; i <= N; i ++) {
            int num = i;
            while(num > 0) {
                int digit = num % 10;
                if(digit != 0 && digit % 3 == 0) {
                    clapCount++;
                }
                num /=10;
            }
        }
        System.out.println(clapCount);

    }
}