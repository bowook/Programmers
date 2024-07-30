import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computersCount = Integer.parseInt(br.readLine());
        int connectedPairComputer = Integer.parseInt(br.readLine());

        boolean[] result = new boolean[computersCount + 1];
        result[1] = true;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= computersCount; i++) {
            graph.add(new ArrayList<>()); // 각 컴퓨터에 대한 연결 리스트 초기화
        }

        for (int i = 0; i < connectedPairComputer; i ++) {
            //컴퓨터가 양방향으로 연결이 되어있으니까 양방향 연결을 해야함
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startPoint = Integer.parseInt(st.nextToken());
            int arrivePoint = Integer.parseInt(st.nextToken());

            graph.get(startPoint).add(arrivePoint);
            graph.get(arrivePoint).add(startPoint);
        }

        Stack<Integer> dfs = new Stack<>();
        dfs.push(1); //1번부터 시작
        int count = 0;
        while(!dfs.isEmpty()) {
            int start = dfs.pop();
            //1번 컴퓨터부터 시작하니까, true면 감염된거임, 그러면 연결된것들도 다 감염시켜야함
            for(int i = 0; i < graph.get(start).size(); i ++) {
                if(!result[graph.get(start).get(i)]) {
                    result[graph.get(start).get(i)] = true;
                    dfs.push(graph.get(start).get(i));
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}