import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        Map<String, Integer> nameToNumber = new HashMap<>();
        Map<Integer, String> numberToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, i);
            numberToName.put(i, name);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (nameToNumber.containsKey(input)) {
                // 포켓몬 번호 출력
                sb.append(nameToNumber.get(input)).append("\n");
            } else {
                // 포켓몬 이름 출력
                int number = Integer.parseInt(input);
                sb.append(numberToName.get(number)).append("\n");
            }
        }

        System.out.print(sb);
    }
}