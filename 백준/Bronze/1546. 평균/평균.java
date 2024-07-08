import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String[] arr = scanner.nextLine().split(" ");
        int[] scores = new int[arr.length];
        for(int i = 0; i < scores.length; i ++) {
            scores[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(scores);

        int maximumScore = scores[N-1];

        double[] correctionScore = new double[N];

        double sum = 0;

        for(int i = 0; i < N; i++) {
            correctionScore[i] = (double) Integer.parseInt(arr[i]) / maximumScore * 100;
            sum += correctionScore[i];
        }

        System.out.println(sum / N);
    }
}