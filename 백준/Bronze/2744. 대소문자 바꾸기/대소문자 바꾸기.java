import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        int[] ascii_arr = new int[str.length()];

        for(int i = 0; i < str.length(); i ++) {

            int ascii = str.charAt(i);
            if(ascii < 97) {
                //대문자는 1
                ascii_arr[i] = 1;
            }
            else {
                //소문자는 0
                ascii_arr[i] = 0;
            }
        }

        for(int i = 0; i < ascii_arr.length; i ++) {
            String letter = str.substring(i, i+1);

            if(ascii_arr[i] == 1) {
                //대문자니까 소문자로
                letter = letter.toLowerCase();
            }
            else if(ascii_arr[i] == 0) {
                letter = letter.toUpperCase();
            }

            result.append(letter);
        }

        System.out.println(result);

    }
}