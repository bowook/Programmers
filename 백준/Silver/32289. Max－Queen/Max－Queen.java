import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        long firstPair = (long) row * (col -1);
        long secondPair = (long) (row - 1) * col;
        long thirdPair = (2L * (row -1)) + (col - 2) * (2L * (row -1));
        
        br.close();
        System.out.println(firstPair + secondPair + thirdPair);

    }
}