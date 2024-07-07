import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testCase; i ++) {
            String answer = scanner.nextLine();
            int score = 0;
            int count = 0;

            for(int j = 0; j < answer.length(); j ++) {
                if(answer.charAt(j) == 'O') {
                    count++;
                    score += count;
                } else {
                    count = 0;
                }
            }
            System.out.println(score);
        }
    }
}