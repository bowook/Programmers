import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<Character, Integer> wordCounts = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            wordCounts.put(c, 0);
        }
        for (char c : input.toCharArray()) {
            wordCounts.put(c, wordCounts.getOrDefault(c, 0) + 1);
        }

        if (input.length() % 2 == 0) {
            boolean isExist = wordCounts.values()
                    .stream()
                    .anyMatch(count -> count % 2 == 1);
            if (isExist) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        } else {
            long countedOdd = wordCounts.values()
                    .stream()
                    .filter(count -> count % 2 == 1)
                    .count();
            if (countedOdd > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        StringBuilder front = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : wordCounts.entrySet()) {
            char word = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count / 2; i++) {
                front.append(word);
            }
            if (count % 2 != 0) {
                mid.append(word);
            }
        }

        StringBuilder palindrome = new StringBuilder();
        palindrome.append(front);
        palindrome.append(mid);
        palindrome.append(front.reverse());

        System.out.println(palindrome);
    }
}
