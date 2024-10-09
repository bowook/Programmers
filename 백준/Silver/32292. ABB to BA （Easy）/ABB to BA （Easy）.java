import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i ++) {
            int sLength = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String previous;

            do {
                previous = s;
                s = s.replace("ABB", "BA");
            } while (!s.equals(previous));

            System.out.println(s);
        }
    }
}