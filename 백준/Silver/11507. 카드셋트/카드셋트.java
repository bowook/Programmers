import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //모양마다 카드가 13장씩 있어야함, 카드 한 세트는 52장
        String S = br.readLine();
        Map<Character, List<Integer>> cardSet = new LinkedHashMap<>();
        cardSet.put('P', new ArrayList<>());
        cardSet.put('K', new ArrayList<>());
        cardSet.put('H', new ArrayList<>());
        cardSet.put('T', new ArrayList<>());

        for (int i = 0; i < S.length(); i += 3) {
            String s = S.substring(i, i + 3);
            char key = s.charAt(0);
            int number = Integer.parseInt(s.substring(1, 3));
            if (cardSet.get(key).contains(number)) {
                System.out.println("GRESKA");
                return;
            }
            List<Integer> numbers = cardSet.get(key);
            numbers.add(number);
        }

        StringBuilder sb = new StringBuilder();
        for (List<Integer> numbers : cardSet.values()) {
            int size = numbers.size();
            sb.append(13 - size).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
