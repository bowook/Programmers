import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[N+1];
        parents = new int[N+1];

        for(int i = 0; i <= N; i ++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeOne = Integer.parseInt(st.nextToken());
            int nodeTwo = Integer.parseInt(st.nextToken());

            graph.get(nodeOne).add(nodeTwo);
            graph.get(nodeTwo).add(nodeOne);
        }

        bfs(1); //Root node

        for(int i = 2; i <= N; i ++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int parentNode = queue.poll();

            for(int neighbor : graph.get(parentNode)) {
                if(!visited[neighbor]) {
                    parents[neighbor] = parentNode;
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}