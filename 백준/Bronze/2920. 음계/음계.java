import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] numbers = new int[arr.length];
        for(int i = 0; i < numbers.length; i ++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        int result = flag(numbers);

        if(result == 1) {
            System.out.println("ascending");
        }
        else if(result == 2) {
            System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }

    }
    public static int flag(int[] numbers) {
        int flagNumber = 0;

        if(numbers[0] == 1) {
            flagNumber = 1;
            for(int i = 1; i < numbers.length -1; i ++) {
                if(numbers[i+1]-numbers[i] != 1) {
                    flagNumber = 3;
                }
            }
        }
        else if (numbers[0] == 8) {
            flagNumber = 2;
            for(int i = 1; i < numbers.length -1; i ++) {
                if(numbers[i]-numbers[i+1] != 1) {
                    flagNumber = 3;
                }
            }
        }
        else {
            flagNumber = 3;
        }

        return flagNumber;
    }
}
