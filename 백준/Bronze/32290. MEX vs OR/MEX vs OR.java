import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[10000];

        for(int i = l; i <= r; i ++) {
            visited[Integer.parseInt(Integer.toBinaryString(i|x),2)] = true;
        }

        for(int i = 0; i < visited.length; i ++) {
            if(!visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}