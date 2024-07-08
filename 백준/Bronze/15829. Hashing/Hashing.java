import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        int num = 1;
        for(char ch = 'a'; ch <= 'z'; ch ++) {
            hm.put(ch, num++);
        }

        Scanner scanner = new Scanner(System.in);

        int strLength = scanner.nextInt();
        scanner.nextLine();

        String str = scanner.nextLine();

        long sum = 0;
        long pow = 1;
        for(int i = 0; i < strLength; i ++) {
            char alpha = str.charAt(i);
            sum += (hm.get(alpha) * pow);
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(sum % 1234567891);
    }
}