import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int mx = 0, mn = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int sandLength = Integer.parseInt(st.nextToken());
            int e = sandLength / X;
            mx += e;
            int gap = e * (Y - X);

            if (sandLength < X) {
                mn += sandLength;
            } else if (gap < (sandLength % X)) {

                int x = 0;
                if (e != 1) {
                    x = sandLength / (e - 1) - 1;
                }
                if (x < X || x > Y) {
                    x = Y;
                }
                mn += sandLength % x;
            }
        }

        System.out.println(mx);
        System.out.println(mn);
        
    }
}