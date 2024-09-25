import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int king = Integer.parseInt(st.nextToken());
        int queen = Integer.parseInt(st.nextToken());
        int look = Integer.parseInt(st.nextToken());
        int beshop = Integer.parseInt(st.nextToken());
        int night = Integer.parseInt(st.nextToken());
        int pone = Integer.parseInt(st.nextToken());
        String sb = (1 - king) + " " + (1 - queen) + " " + (2 - look) + " " +
                (2 - beshop) + " " + (2 - night) + " " + (8 - pone);

        System.out.println(sb);
    }
}