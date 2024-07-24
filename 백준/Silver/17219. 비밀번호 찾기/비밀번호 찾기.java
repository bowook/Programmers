import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < M; i ++) {
            String addr = br.readLine();
            sb.append(map.get(addr)).append("\n");
        }
        System.out.println(sb);
    }
}