import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] chessBoard;
    private static int N;
    private static int counts;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chessBoard = new int[N];
        
        place(0);
        
        System.out.println(counts);
    }

    private static void place(int row) {
        if (row == N) {
            counts ++;
            return;
        }

        for (int col = 0; col < N; col ++) {
            //배치할 때 같은 열과 대각선에 있는지 확인해야함
            if (isPossible(row, col)) {
                chessBoard[row] = col;
                //놨으면 다음 행에 놔야함
                place(row + 1);
            }
        }
    }

    private static boolean isPossible(int row, int col) {
        for (int i = 0; i < row; i ++) {
            if (chessBoard[i] == col) {
                //같은 열에 이미 퀸이 있음
                return false;
            }

            int x = Math.abs(row - i);
            int y = Math.abs(col - chessBoard[i]);
            if (x == y) {
                //같은 대각선이라서 못 놓음
                return false;
            }
        }
        return true;
    }
}