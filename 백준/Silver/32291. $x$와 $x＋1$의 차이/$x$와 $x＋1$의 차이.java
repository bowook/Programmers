import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long x = Long.parseLong(br.readLine());
        long y = x + 1;
        br.close();

        StringBuilder sb = new StringBuilder();
        
        long i = 1;
        while (i <= x) {
            long divX = x / i;
            long divY = y / i;

            if (divX != divY) {
                sb.append(i).append(" ");
            }
            
            long nextI = Math.min(x / divX, y / divY);
            i = nextI + 1;
        }

        System.out.println(sb.toString().trim());
    }
}