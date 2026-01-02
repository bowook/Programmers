import java.util.*;
import java.io.*;

public class Main {

    private static final int EMPTY = 0;
    private static final int WALL = 6;
    private static final int WATCHED = 9;
    
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    private static List<int[]> cctvs;
    private static int minBlindSpot = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] office = new int[N][M];
        cctvs = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, office[i][j]}); // r, c, type 저장
                }
            }
        }

        solve(0, office);
        System.out.println(minBlindSpot);
    }

    private static void solve(int depth, int[][] currentOffice) {
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countEmpty(currentOffice));
            return;
        }

        int[] cctv = cctvs.get(depth);
        int r = cctv[0];
        int c = cctv[1];
        int type = cctv[2];

        for (int dir = 0; dir < getRotationMaxCounts(type); dir++) {
            int[][] copiedOffice = copy(currentOffice);
            watch(type, dir, r, c, copiedOffice);
            solve(depth + 1, copiedOffice);
        }
    }

    private static void watch(int type, int dir, int r, int c, int[][] map) {
        if (type == 1) {
            draw(r, c, dir, map);
        } else if (type == 2) {
            draw(r, c, dir, map);
            draw(r, c, (dir + 2) % 4, map);
        } else if (type == 3) {
            draw(r, c, dir, map);
            draw(r, c, (dir + 1) % 4, map);
        } else if (type == 4) {
            draw(r, c, dir, map);
            draw(r, c, (dir + 1) % 4, map);
            draw(r, c, (dir + 2) % 4, map);
        } else if (type == 5) {
            for (int d = 0; d < 4; d++) {
                draw(r, c, d, map);
            }
        }
    }

    private static void draw(int r, int c, int dir, int[][] map) {
        int nr = r + dx[dir];
        int nc = c + dy[dir];

        while (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && map[nr][nc] != WALL) {
            if (map[nr][nc] == EMPTY) {
                map[nr][nc] = WATCHED;
            }
            nr += dx[dir];
            nc += dy[dir];
        }
    }

    private static int countEmpty(int[][] map) {
        int count = 0;
        for (int[] row : map) {
            for (int val : row) {
                if (val == EMPTY) count++;
            }
        }
        return count;
    }

    private static int[][] copy(int[][] origin) {
        int[][] res = new int[origin.length][origin[0].length];
        for (int i = 0; i < origin.length; i++) {
            res[i] = origin[i].clone();
        }
        return res;
    }

    private static int getRotationMaxCounts(int type) {
        if (type == 2) return 2;
        if (type == 5) return 1;
        return 4;
    }
}