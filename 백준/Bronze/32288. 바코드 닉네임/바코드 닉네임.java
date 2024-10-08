import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String nickname = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i ++) {
            if(Character.isLowerCase(nickname.charAt(i))) {
                sb.append(Character.toUpperCase(nickname.charAt(i)));
                continue;
            }

            sb.append(Character.toLowerCase(nickname.charAt(i)));

        }
        br.close();
        System.out.println(sb);
    }
}