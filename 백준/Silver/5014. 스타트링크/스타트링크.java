import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final String IMPOSSIBLE_ELEVATOR = "use the stairs";
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxFloor = Integer.parseInt(st.nextToken());
        int currentFloor = Integer.parseInt(st.nextToken());
        int targetFloor = Integer.parseInt(st.nextToken());
        int upFloor = Integer.parseInt(st.nextToken());
        int downFloor = Integer.parseInt(st.nextToken());

        visited = new boolean[maxFloor + 1];
        int[][] floors = new int[maxFloor + 1][1];

        int result = bfs(floors, currentFloor, upFloor, downFloor, targetFloor);
        if (result == -1) {
            System.out.println(IMPOSSIBLE_ELEVATOR);
            return;
        }
        System.out.println(result);
    }

    private static int bfs(int[][] floors, int floor, int up, int down, int target) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{floor, 0});
        visited[floor] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentFloor = current[0];
            int currentCounts = current[1];

            if (currentFloor == target) {
                return currentCounts;
            }
            
            //위로 먼저
            int upFloor = currentFloor + up;
            if (upFloor >= 1 && upFloor < floors.length && !visited[upFloor]) {
                deque.addLast(new int[]{upFloor, currentCounts + 1});
                visited[upFloor] = true;
            }

            int downFloor = currentFloor - down;
            if (downFloor >= 1 && downFloor < floors.length && !visited[downFloor]) {
                deque.addLast(new int[]{downFloor, currentCounts + 1});
                visited[downFloor] = true;
            }
        }

        return -1;
    }
}