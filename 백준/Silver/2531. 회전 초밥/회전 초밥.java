import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int placedDishes = Integer.parseInt(st.nextToken());
        int sushiTypes = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());
        int couponSushiNumber = Integer.parseInt(st.nextToken());

        int[] belt = new int[placedDishes];
        for (int i = 0; i < placedDishes; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] eatingCounts = new int[sushiTypes + 1];
        int unique = 0;
        for (int i = 0; i < windowSize; i++) {
            int sushiType = belt[i];
            if (eatingCounts[sushiType] == 0) {
                unique++;
            }
            eatingCounts[sushiType]++;
        }

        int max;
        if (eatingCounts[couponSushiNumber] == 0) {
            max = unique + 1;
        } else {
            max = unique;
        }

        for (int i = 1; i < placedDishes; i++) {
            int removedSushi = belt[(i - 1) % placedDishes];
            int eatSushi = belt[(i + windowSize - 1) % placedDishes];

            eatingCounts[removedSushi]--;
            if (eatingCounts[removedSushi] == 0) {
                unique--;
            }

            if (eatingCounts[eatSushi] == 0) {
                unique++;
            }
            eatingCounts[eatSushi]++;

            int current;
            if (eatingCounts[couponSushiNumber] == 0) {
                current = unique + 1;
            } else {
                current = unique;
            }

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
