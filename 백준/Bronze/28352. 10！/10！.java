import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long inputNum = Long.parseLong(br.readLine());
        long factorial = 1;

        for(int i = 1; i <= inputNum; i ++) {
            factorial = factorial * i;
        }

        long result = factorial / (7*24*60*60);

        sb.append(result);

        System.out.println(sb);
    }
}