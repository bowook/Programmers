import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peoples = scanner.nextInt();
        scanner.nextLine();

        int max = 0;
        for(int i = 0; i < peoples; i ++) {
            String[] arr = scanner.nextLine().split(" ");
            int[] scores = new int[arr.length];
            for(int j = 0; j < scores.length; j++) {
                scores[j] = Integer.parseInt(arr[j]);
            }

            int score = scores[0] * (scores[1] + scores[2]);
            if(scores[0] == (scores[1] + scores[2])) {
                //점수 2배
                score = score * 2;
            }

            if(max <= score) {
                max = score;
            }

        }
        System.out.println(max);
    }
}