import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;

    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for(int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j ++) {
                paper[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        partition(0,0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if(check(row,col,size)) {
            if(paper[row][col] == 0) {
                //흰색
                white += 1;
            }
            else {
                blue += 1;
            }
            return;
        }
        int newSize = size / 2;
        //check 값이 false면 하나의 색만 있는게 아니니까 분할
        partition(row,col,newSize);
        partition(row+newSize, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    public static boolean check(int row, int col, int size) {
        int color = paper[row][col];

        for(int i = row; i < row+size; i ++) {
            for(int j = col; j < col + size; j ++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}