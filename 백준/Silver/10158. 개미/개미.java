import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        x = (x + time) % (w * 2);
        y = (y + time) % (h * 2);

        if (x > w) {
            x = (w * 2) - x;
        }
        if (y > h) {
            y = (h * 2) - y;
        }

        System.out.print(x + " " + y);
    }
}
