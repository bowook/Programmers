import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int[][] points = new int[N][2];

        for(int i = 0; i < N; i ++) {
            String[] tempArr = scanner.nextLine().split(" ");
            points[i][0] = Integer.parseInt(tempArr[0]);
            points[i][1] = Integer.parseInt(tempArr[1]);
        }

        Arrays.sort(points, (a,b) -> {
            if(a[1] == b[1]) {
                //y좌표가 같으면
                return Integer.compare(a[0],b[0]);
            }
            else {
                return Integer.compare(a[1], b[1]);
            }
        });

        for(int i = 0; i < N; i ++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}