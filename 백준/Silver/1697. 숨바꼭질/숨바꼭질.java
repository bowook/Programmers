import java.util.*;
import java.io.*;

public class Main {
    
    private static final int maxCol = 100001;
    
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startLine = br.readLine().split(" ");
        int N = Integer.parseInt(startLine[0]);
        int K = Integer.parseInt(startLine[1]);
        visited = new boolean[100001];
        
        bfs(N, K);
    }
    
    private static void bfs(int start, int target) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{start,0});
        visited[start] = true;
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentPos = current[0];
            int currentMoves = current[1];
            
            if (currentPos == target) {
                System.out.println(currentMoves);
                return;
            }
            
            int plusWalk = currentPos + 1;
            int minusWalk = currentPos - 1;
            int multiplyWalk = currentPos * 2;
            
            if (plusWalk >= 0 && plusWalk < maxCol && !visited[plusWalk]) {
                deque.addLast(new int[]{plusWalk, currentMoves + 1});
                visited[plusWalk] = true;
            }
            if (minusWalk >= 0 && minusWalk < maxCol && !visited[minusWalk]) {
                deque.addLast(new int[]{minusWalk, currentMoves + 1});
                visited[minusWalk] = true;
            }
            if (multiplyWalk >= 0 && multiplyWalk < maxCol && !visited[multiplyWalk]) {
                deque.addLast(new int[]{multiplyWalk, currentMoves + 1});
                visited[multiplyWalk] = true;
            }
        }
    }
}