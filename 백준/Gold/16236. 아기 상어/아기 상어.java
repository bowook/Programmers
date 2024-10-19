import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static int[][] water;
    private static int N;
    private static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new int[N][N];

        int startRow = 0, startCol = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                water[i][j] = Integer.parseInt(st.nextToken());
                if (water[i][j] == 9) {
                    startRow = i;
                    startCol = j;
                    water[i][j] = 0;
                }
            }
        }
        br.close();

        bfs(startRow, startCol);

        System.out.println(time);
    }

    private static void bfs(int row, int col) {
        int currentSize = 2; // 아기 상어의 초기 크기
        int eatCount = 0;    // 먹은 물고기 수

        while (true) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            queue.offer(new int[] { row, col, 0 }); // {row, col, distance}
            visited[row][col] = true;

            ArrayList<int[]> fishList = new ArrayList<>(); // 먹을 수 있는 물고기
            int minDistance = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentCol = current[1];
                int currentDistance = current[2];

                // 현재 물고기까지의 거리가 이미 찾은 최소 거리보다 크다면
                if (currentDistance > minDistance) {
                    break;
                }

                if (water[currentRow][currentCol] > 0 && water[currentRow][currentCol] < currentSize) {
                    fishList.add(new int[] { currentRow, currentCol, currentDistance });
                    minDistance = currentDistance; // 현재 거리로 최소 거리 업데이트
                }

                for (int[] direction : directions) {
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];

                    if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && !visited[newRow][newCol]
                            && water[newRow][newCol] <= currentSize) {
                        queue.offer(new int[] { newRow, newCol, currentDistance + 1 });
                        visited[newRow][newCol] = true;
                    }
                }
            }

            // 더 이상 먹을 물고기가 없다
            if (fishList.isEmpty()) {
                break;
            }

            fishList.sort((a, b) -> {
                if (a[2] == b[2]) { // 거리가 같을 경우
                    if (a[0] == b[0]) { // 같은 행일 경우
                        return Integer.compare(a[1], b[1]); // 왼쪽(열) 우선
                    }
                    return Integer.compare(a[0], b[0]); // 위쪽(행) 우선
                }
                return Integer.compare(a[2], b[2]); // 거리 우선
            });

            // 가장 가까운 물고기를 먹음
            int[] chosenFish = fishList.get(0);
            row = chosenFish[0];
            col = chosenFish[1];
            water[row][col] = 0; // 물고기를 먹은 자리는 빈 칸으로 처리
            time += chosenFish[2]; // 이동한 거리만큼 시간을 추가
            eatCount++;

            if (eatCount == currentSize) {
                currentSize++;
                eatCount = 0; // 먹은 물고기 수 초기화
            }
        }
    }
}