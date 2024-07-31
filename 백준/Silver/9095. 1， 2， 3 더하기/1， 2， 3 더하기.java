import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer> dp = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        //1,2,3의 합으로 나타내는 방법의 수

        dp.add(1); //1은 1
        dp.add(2); //2는 1+1, 2 2개
        dp.add(4); //3은 1+1+1, 2+1 2, 3 4개

        for(int i = 3; i < 11; i ++) {
            dp.add(dp.get(i-3) + dp.get(i-2) + dp.get(i-1));
        }

        for(int i = 0; i < T; i ++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp.get(N-1)).append("\n");
        }

        System.out.println(sb);
    }
}