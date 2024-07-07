import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Character,Integer> h1 = new HashMap<Character,Integer>();

        String str = scanner.nextLine();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            h1.put(ch, -1);
        }

        for(int i = 0; i < str.length(); i++) {
            char alphabet = str.charAt(i);
            h1.put(alphabet, str.indexOf(alphabet));
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(h1.get(ch) + " ");
        }
    }
}