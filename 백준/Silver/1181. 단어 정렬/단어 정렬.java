import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //알파벳 소문자로 이루어진 N개의 단어
        //길이가 짧은 것부터 정렬!
        //길이가 같으면 사전 순으로 정렬
        //중복된 단어는 하나만 남기고 제거
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[N];

        for(int i = 0; i < N; i ++) {
            words[i] = scanner.nextLine();
        }

        String[] distinctedSorted = distinct(words);

        for(int i = 0; i < distinctedSorted.length; i ++) {
            System.out.println(distinctedSorted[i]);
        }

    }

    public static String[] distinct(String[] words) {
        HashMap<String,Integer> hmap = new HashMap<String,Integer>();
        for(int i = 0; i < words.length; i ++) {
            hmap.put(words[i],words[i].length());
        }
        String[] distinctWords = hmap.keySet().toArray(new String[0]);

        return sorting(distinctWords);
    }

    public static String[] sorting(String[] distincted) {
        Arrays.sort(distincted, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });

        return distincted;
    }
}