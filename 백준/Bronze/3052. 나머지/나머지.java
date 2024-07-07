import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();

        for(int i = 0; i < 10; i ++) {
            int num = scanner.nextInt();
            scanner.nextLine();

            hashMap.put(num%42,i);
        }

        System.out.println(hashMap.size());
    }
}