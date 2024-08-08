import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //방향 없는 그래프
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // Vertex 수임
        int M = Integer.parseInt(st.nextToken()); // Edge 수임

        //Edges마다 연결된 정점의 2개를 보여주는거임
         graph = new ArrayList<>();

        //초기 리스트 초기화
        for(int i = 0; i <= N; i ++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int vertexOne = Integer.parseInt(st.nextToken());
            int vertexTwo = Integer.parseInt(st.nextToken());
            graph.get(vertexOne).add(vertexTwo);
            graph.get(vertexTwo).add(vertexOne);
        }

        visited = new boolean[N+1];

        int count = 0;
        //DFS로 탐색하면 끝이네!!
        for(int i = 1; i <= N; i ++) {
            if(!visited[i]) {
                //false여야 탐색 안한거
                dfs(i);
                count += 1;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int vertex) {
        visited[vertex] = true;

        for(int i = 0; i < graph.get(vertex).size(); i ++) {
            if(!visited[graph.get(vertex).get(i)]) {
                dfs(graph.get(vertex).get(i));
            }
        }
    }
}