import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //6 12 18 씩 증가하는군
        //0 1 2 3 4
        //1 7 19 37 61
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        int max = 1; // -> max 1번
        if(N == 1) {
            System.out.println(1);
        }
        else {
            for(int i = 1; i <= N; i ++) {
                max += i * 6; // i가 1일 때 max 7, i가 2일 때 max 19, i가 3일 때 max 37 i가 4일 때는 61

                if(N <= max) {
                    System.out.print(i+1);
                    break;
                }
            }
        }
    }
}