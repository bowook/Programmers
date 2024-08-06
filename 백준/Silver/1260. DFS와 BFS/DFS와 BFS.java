import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int vertexStartNumber = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[vertexCount + 1];

        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int vertexNum1 = Integer.parseInt(st.nextToken());
            int vertexNum2 = Integer.parseInt(st.nextToken());

            graph.get(vertexNum1).add(vertexNum2);
            graph.get(vertexNum2).add(vertexNum1);
        }

        // 방문 순서를 보장하기 위해 정렬
        for (int i = 0; i <= vertexCount; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 실행
        dfs(vertexStartNumber);
        System.out.println();

        // 방문 배열 초기화
        Arrays.fill(visited, false);

        // BFS 실행
        bfs(vertexStartNumber);
    }

    static void dfs(int startNumber) {
        visited[startNumber] = true;
        System.out.print(startNumber + " ");

        for (int next : graph.get(startNumber)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int startNumber) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNumber);
        visited[startNumber] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}