import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String NM_str = br.readLine();
        int N = Integer.parseInt(NM_str.split(" ")[0]);
        int M = Integer.parseInt(NM_str.split(" ")[1]);

        String[][] arr = new String[N][M];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();

            for(int j = 0 ; j < M ; j++) {
                if(str.charAt(j) == 'W') {
                    arr[i][j] = "W";
                }else {
                    arr[i][j] = "B";
                }
            }
        }

        int min = 64;

        for(int i = 0 ; i < N - 7 ; i++) { // 세로
            for(int j = 0 ; j < M - 7 ; j++) { // 가로
                min = Math.min(min, cal(i, j, arr)); // 최소값
            }
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int cal(int x, int y, String[][] WB) {

        int count = 0;

        String color = "W"; // 첫번째 칸

        for(int i = x ; i < x + 8 ; i++) { // 시작
            for(int j = y ; j < y + 8 ; j++) { //시작

               
                if(!WB[i][j].equals(color)) {
                    count++;
                }

                if(color.equals("W")) {
                    color = "B";
                }else {
                    color = "W";
                }
            }

            if(color.equals("W")) { 
                color = "B";
            }else {
                color = "W";
            }
        }

        count = Math.min(count, 64 - count);

        return count;

    }
}