import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        String[] arr = scanner.nextLine().split(" ");
        List<Integer> listNumbers = new ArrayList<>();
        for(int i = 0; i < length; i ++) {
            listNumbers.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(listNumbers);
        int sum = 0;
        for(int i = 0; i < length-1; i ++) {
            sum += listNumbers.get(i);
        }
        System.out.println(sum);


    }
}