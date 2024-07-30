import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] score = new int[count];
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (count == 1) {
            System.out.println(score[0]);
            return;
        }
        else if(count == 2) {
            System.out.println(score[0] + score[1]);
            return;
        }
        
        dp.add(score[0]);
        dp.add(score[0] + score[1]);

        for(int i = 2; i < count; i ++) {
            dp.add(Math.max(dp.get(i-2), score[i-1]) + score[i]);
            if(i>2) {
                dp.set(i, Math.max(dp.get(i-2), dp.get(i-3) + score[i-1])+ score[i]);
            }
        }
        System.out.println(dp.get(count-1));
    }
}