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

        int sum = 0;
        for(int i = 0; i < str.length(); i ++) {
            char alpha = str.charAt(i);
            sum += hm.get(alpha) * Math.pow(31, i);
        }

        System.out.println(sum);
    }
}