import java.util.*;
import java.io.*;

public class Main {

    private static int[][] notebook;
    private static List<int[][]> stickers = new ArrayList<>();
    private static int counts = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        notebook = new int[N][M];
        for (int i = 0; i < K; i ++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[row][col];
            for (int r = 0; r < row; r ++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < col; c ++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            stickers.add(sticker);
        }

        solve(0, notebook);

        System.out.println(counts);
    }

    private static void solve(int depth, int[][] currentNotebook) {
        if (depth == stickers.size()) {
            int count = calculateStikcers(currentNotebook);
            counts = Math.max(count, counts);

            return;
        }

        int[][] sticker = stickers.get(depth);
        int stickerRow = sticker.length;
        int stickerCol = sticker[0].length;
        for (int rotation = 0; rotation < 4; rotation ++) {
            // 현재 이 모양으로 배치 가능한 곳에는 다 배치하려고 해봐야함.
            int[][] rotatedSticker = rotate(sticker, rotation);
            int row = rotatedSticker.length;
            int col = rotatedSticker[0].length;
    
            boolean isAttached = false;
            for (int startRow = 0; startRow <= currentNotebook.length - row; startRow ++) {
                for (int startCol = 0; startCol <= currentNotebook[0].length - col; startCol ++) {
                    // 붙혀야함.
                    if (isAttach(startRow, startCol, rotatedSticker, currentNotebook)) {
                        attach(startRow, startCol, rotatedSticker, currentNotebook);
                        isAttached = true;
                        break;
                    }
                }
                if (isAttached) {
                    break;
                }
            }
            if (isAttached) {
                solve(depth +  1, currentNotebook);
                return;
            }
        }
        solve(depth + 1, currentNotebook);
    }
    
    private static void attach(int startRow, int startCol, int[][] sticker, int[][] currentNotebook) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    currentNotebook[startRow + i][startCol + j] = 1;
                }
            }
        }
    }
    
    private static boolean isAttach(int row, int col, int[][] sticker, int[][] currentNotebook) {
        for (int i = row; i < sticker.length + row; i ++) {
            for (int j = col; j < sticker[0].length + col; j ++) {
                if (sticker[i-row][j-col] == 1 && currentNotebook[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] rotate(int[][] sticker, int rotationCount) {
        if (rotationCount == 0) {
            return sticker;
        }
        else if (rotationCount == 1) {
            int[][] rotatedSticker = new int[sticker[0].length][sticker.length];
            for (int col = 0; col < sticker[0].length; col ++) {
                for (int row = 0; row < sticker.length; row ++) {
                    rotatedSticker[col][row] = sticker[sticker.length -1 - row][col];
                }
            }

            return rotatedSticker;
        }
        else if (rotationCount == 2) {
            int[][] rotatedSticker = new int[sticker.length][sticker[0].length];
            for (int row = 0; row < sticker.length; row ++) {
                for (int col = 0; col < sticker[0].length; col ++) {
                    rotatedSticker[row][col] = sticker[sticker.length -1 -row][sticker[0].length -1 - col];
                }
            }

            return rotatedSticker;
        }
        int[][] rotatedSticker = new int[sticker[0].length][sticker.length];
        for (int col = 0; col < sticker[0].length; col ++) {
            for (int row = 0; row < sticker.length; row ++) {
                rotatedSticker[col][row] = sticker[row][sticker[0].length -1 - col];
            }
        }
        
        return rotatedSticker;
    }
    

    private static int calculateStikcers(int[][] currentNotebook) {
        int count = 0;
        for (int i = 0; i < currentNotebook.length; i ++) {
            for (int j = 0; j < currentNotebook[0].length; j ++) {
                if (currentNotebook[i][j] == 1) {
                    count ++;
                }
            }
        }

        return count;
    }
}