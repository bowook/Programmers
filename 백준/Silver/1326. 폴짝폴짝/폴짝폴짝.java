
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int ans = -1;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        bfs(n, start, end);

        bw.write(ans+"");


        br.close();
        bw.close();
    }

    private static void bfs(int n, int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == end){
                ans = cur[1];
                return;
            }
            int move = arr[cur[0]];

            for (int i = cur[0]; i < n+1; i+=move) {
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i, cur[1]+1});
                }
            }

            for (int i = cur[0]; i > 0; i-=move) {
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i, cur[1]+1});
                }
            }

        }
    }

}
