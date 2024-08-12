import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph;
    private static int[] scores;
    private static int userCounts = 0;

    public static void main(String[] args) throws IOException {
        //케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        userCounts = Integer.parseInt(st.nextToken());
        int friendRelationship = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        scores = new int[userCounts+1];

        for(int i = 0; i <= userCounts; i ++) {
            graph.add(i, new ArrayList<>());
        }

        for(int i = 0; i < friendRelationship; i ++) {
            st = new StringTokenizer(br.readLine());
            int friendOne = Integer.parseInt(st.nextToken());
            int friendTwo = Integer.parseInt(st.nextToken());

            graph.get(friendOne).add(friendTwo);
            graph.get(friendTwo).add(friendOne);
        }

        for(int i = 1; i <= userCounts; i ++) {
            bfs(i);
        }
        int answer = -1;
        int minLength = Integer.MAX_VALUE;

        for(int i = 1; i < scores.length; i ++) {
            if(minLength > scores[i]) {
                minLength = scores[i];
                answer = i;
            }

            else if(minLength == scores[i]) {
                Math.min(answer,i);
            }
        }

        System.out.println(answer);

    }
    private static void bfs(int friendNumber) {
        boolean[] visited = new boolean[userCounts + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(friendNumber);
        visited[friendNumber] = true;

        int repeatCount = 0; // 단계 수
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 단계의 노드 수
            repeatCount++; // 현재 단계의 시작 시점에 증가

            for (int i = 0; i < size; i++) {
                int tempNumber = queue.poll(); // 큐에서 노드 꺼내기

                for (int neighbor : graph.get(tempNumber)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor); // 인접 노드를 큐에 추가
                        scores[friendNumber] += repeatCount; // 점수에 현재 단계 수 추가
                    }
                }
            }
        }
    }
}