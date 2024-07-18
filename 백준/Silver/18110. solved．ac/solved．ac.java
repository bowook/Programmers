import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int trimmedMean = (int) Math.round(n * 0.15);
        int sum = 0;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i ++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for(int i = trimmedMean; i < n - trimmedMean; i ++) {
            sum += list.get(i);
        }

        double mean = (double) sum / (n - 2 * trimmedMean);
        System.out.println(Math.round(mean));
    }
}