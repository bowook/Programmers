import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testCase; i ++) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            int loopCount = Integer.parseInt(arr[0]);

            String result = "";
            int arrLength = arr[1].length();
            int arrIndex = 0;
            for(int j = 1; j < (loopCount * arrLength)+1; j ++) {
                result += arr[1].charAt(arrIndex);

                if(j % Integer.parseInt(arr[0]) == 0) {
                    //3번 반복했다는 의미
                    arrIndex+=1;
                }

            }
            System.out.println(result);
        }

    }
}