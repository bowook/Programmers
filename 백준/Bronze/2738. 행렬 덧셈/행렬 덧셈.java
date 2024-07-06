import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        int[][] firstArray = new int[num1][num2];
        int[][] secondArray = new int[num1][num2];
        int[][] sumArray = new int[num1][num2];

        for(int i = 0; i < num1; i ++) {
            String unit = scanner.nextLine();
            String[] tempArr = unit.split(" ");
            int[] tempNumbers = new int[tempArr.length];
            for(int k = 0; k < num2; k ++) {
                tempNumbers[k] = Integer.parseInt(tempArr[k]);
            }
            for(int j = 0; j < num2; j ++) {
                firstArray[i][j] = tempNumbers[j];
            }
        }

        for(int i = 0; i < num1; i ++) {
            String unit = scanner.nextLine();
            String[] tempArr = unit.split(" ");
            int[] tempNumbers = new int[tempArr.length];
            for(int k = 0; k < num2; k ++) {
                tempNumbers[k] = Integer.parseInt(tempArr[k]);
            }
            for(int j = 0; j < num2; j ++) {
                secondArray[i][j] = tempNumbers[j];
            }
        }


        for(int i = 0; i < num1; i ++) {
            for(int j = 0; j < num2; j ++) {
                sumArray[i][j] = firstArray[i][j] + secondArray[i][j];
            }
        }
        for(int i = 0; i < num1; i ++) {
            for(int j = 0; j < num2; j ++) {
                System.out.print(sumArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}