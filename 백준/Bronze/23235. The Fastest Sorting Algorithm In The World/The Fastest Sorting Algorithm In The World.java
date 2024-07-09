import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = 1;
        while(true) {

            String str = scanner.nextLine();

            if(str.equals("0")) {
                break;
            }

            else {
                System.out.println("Case " + count + ": Sorting... done!");
                count ++;
            }

        }
    }
}