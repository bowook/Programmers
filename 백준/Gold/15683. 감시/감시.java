import java.util.*;
import java.io.*;

public class Main {

    private static final int EMPTY = 0;
    private static final int WALL = 6;
    private static int[][] office;
    private static List<int[]> cctvs;
    private static int counts = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        cctvs = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j ++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != EMPTY && office[i][j] != WALL) {
                    cctvs.add(new int[]{i,j});
                }
            }
        }

        solve(0, office);
        
        System.out.println(counts);
    }

    private static void solve(int depth, int[][] currentOffice) {
        if (depth == cctvs.size()) {
            // 계산해서 나온 값이랑
            int countsEmpty = countEmpty(currentOffice);
            // Math.min으로 최소값 구해야함
            counts = Math.min(counts, countsEmpty);
            return;
        }

        int[] cctv = cctvs.get(depth);
        int cctvType = office[cctv[0]][cctv[1]];
        //이 cctv로 색칠을 해야함
        for (int i = 0; i < getRotationMaxCounts(cctvType); i ++) {
            //복사를 해야하는
            int[][] copiedOffice = copy(currentOffice);
            //감시해야함
            watch(cctvType, i, cctv, copiedOffice);
            solve(depth + 1, copiedOffice);
        }
    }

    private static int countEmpty(int[][] currentOffice) {
        int count = 0;
        for (int i = 0; i < currentOffice.length; i ++) {
            for (int j = 0; j < currentOffice[0].length; j ++) {
                if (currentOffice[i][j] == EMPTY) {
                    count += 1;
                }
            }
        }

        return count;
    }

    private static void watch(int cctvType, int direction, int[] cctv, int[][] copiedOffice) {
        int row = cctv[0];
        int col = cctv[1];
        
        if (cctvType == 1 && direction == 0) {
            drawRight(row, col, copiedOffice);
            return;
        }

        if (cctvType == 1 && direction == 1) {
            drawUp(row, col, copiedOffice);
            return;
        }

        if (cctvType == 1 && direction == 2) {
            drawLeft(row, col, copiedOffice);
            return;
        }

        if (cctvType == 1 && direction == 3) {
            drawDown(row, col, copiedOffice);
            return;
        }

        if (cctvType == 2 && direction == 0) {
            drawRight(row, col, copiedOffice);
            drawLeft(row, col, copiedOffice);
            return;
        }

        if (cctvType == 2 && direction == 1) {
            drawUp(row, col, copiedOffice);
            drawDown(row, col, copiedOffice);
            return;
        }

        if (cctvType == 3 && direction == 0) {
            drawRight(row, col, copiedOffice);
            drawUp(row, col, copiedOffice);
            return;
        }
        if (cctvType == 3 && direction == 1) {
            drawUp(row, col, copiedOffice);
            drawLeft(row, col, copiedOffice);
            return;
        }
        if (cctvType == 3 && direction == 2) {
            drawLeft(row, col, copiedOffice);
            drawDown(row, col, copiedOffice);
            return;
        }
        if (cctvType == 3 && direction == 3) {
            drawDown(row, col, copiedOffice);
            drawRight(row, col, copiedOffice);
            return;
        }

        if (cctvType == 4 && direction == 0) {
            drawRight(row, col, copiedOffice);
            drawUp(row, col, copiedOffice);
            drawLeft(row, col, copiedOffice);
            return;
        }

        if (cctvType == 4 && direction == 1) {
            drawUp(row, col, copiedOffice);
            drawLeft(row, col, copiedOffice);
            drawDown(row, col, copiedOffice);
            return;
        }

        if (cctvType == 4 && direction == 2) {
            drawLeft(row, col, copiedOffice);
            drawDown(row, col, copiedOffice);
            drawRight(row, col, copiedOffice);
            return;
        }

        if (cctvType == 4 && direction == 3) {
            drawDown(row, col, copiedOffice);
            drawRight(row, col, copiedOffice);
            drawUp(row, col, copiedOffice);
            return;
        }

        if (cctvType == 5 && direction == 0) {
            drawRight(row, col, copiedOffice);
            drawUp(row, col, copiedOffice);
            drawLeft(row, col, copiedOffice);
            drawDown(row, col, copiedOffice);
            return;
        }
    }

    private static void drawRight(int row, int col, int[][] copiedOffice) {
        for (int i = col; i < copiedOffice[0].length; i ++) {
            if (copiedOffice[row][i] == WALL) {
                return;
            }  
            copiedOffice[row][i] = 9;
        }
    }

    private static void drawUp(int row, int col, int[][] copiedOffice) {
        for (int i = row; i >= 0; i --) {
            if (copiedOffice[i][col] == WALL) {
                return;
            }
            copiedOffice[i][col] = 9;
        }
    }

    private static void drawLeft(int row, int col, int[][] copiedOffice) {
        for (int i = col; i >= 0; i --) {
            if (copiedOffice[row][i] == WALL) {
                return;
            }
            copiedOffice[row][i] = 9;
        }
    }

    private static void drawDown(int row, int col, int[][] copiedOffice) {
        for (int i = row; i < copiedOffice.length; i ++) {
            if (copiedOffice[i][col] == WALL) {
                return;
            }
            copiedOffice[i][col] = 9;
        }
    }
    
    private static int[][] copy(int[][] currentOffice) {
        int[][] copiedOffice = new int[currentOffice.length][currentOffice[0].length];
        for (int i = 0; i < currentOffice.length; i ++) {
            for (int j = 0; j < currentOffice[0].length; j ++) {
                copiedOffice[i][j] = currentOffice[i][j];
            }
        }

        return copiedOffice;
    }

    private static int getRotationMaxCounts(int cctvType) {
        if (cctvType == 1) {
            return 4;
        }
        else if (cctvType == 2) {
            return 2;
        }
        else if (cctvType == 3) {
            return 4;
        }
        else if (cctvType == 4) {
            return 4;
        }
        else {
            return 1;
        }
    }
}