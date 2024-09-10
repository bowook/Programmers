import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            if(row == col) {
                sb.append("dohoon").append("\n");
                continue;
            }

            if(row == 1 || col == 1) {
                //무조건 진서 승 -> 첫 턴에 1로 걍 보내버리면됨 진서 천상계
                sb.append("jinseo").append("\n").append(1).append(" ").append(1).append("\n");
                continue;
            }

            if(row > col) {
                sb.append("jinseo").append("\n").append(col).append(" ").append(col).append("\n");
            }
            else {
                sb.append("jinseo").append("\n").append(row).append(" ").append(row).append("\n");
            }
        }
        System.out.println(sb);
    }
}