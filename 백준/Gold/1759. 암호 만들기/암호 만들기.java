import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final List<String> consonant = List.of("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p",
            "q", "r", "s", "t", "v", "w", "x", "y", "z");
    private static final List<String> vowel = List.of("a", "e", "o", "i", "u");
    private static final List<String> strings = new ArrayList<>();
    private static int LENGTH;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LENGTH = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);

        int temp = C - LENGTH;
        for (int i = 0; i <= temp; i++) {
            recursive(0, i, alphabets, new Stack<>());
        }

        for (String str : strings) {
            System.out.println(str);
        }
    }

    private static void recursive(int count, int index, String[] alphabets, Stack<String> stack) {
        if (count == LENGTH) {
            StringBuilder stringBuilder = new StringBuilder();
            int vowelCount = 0;
            int consonantCount = 0;
            for (String s : stack) {
                if (vowel.contains(s)) {
                    vowelCount += 1;
                } else if (consonant.contains(s)) {
                    consonantCount += 1;
                }
                stringBuilder.append(s);
            }

            if (vowelCount < 1 || consonantCount < 2) {
                return;
            }

            if (!strings.contains(stringBuilder.toString())) {
                strings.add(stringBuilder.toString());
            }
            return;
        }

        if (index >= alphabets.length) {
            return;
        }

        stack.add(alphabets[index]);
        recursive(count + 1, index + 1, alphabets, stack);

        stack.pop();
        for (int i = 1; i <= alphabets.length - 1 - index; i++) {
            recursive(count, index + i, alphabets, stack);
        }
    }
}
