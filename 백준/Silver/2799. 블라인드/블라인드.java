import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static String NOTHING = "................";
    private static String ONE = "****............";
    private static String TWO = "********........";
    private static String THREE = "************....";
    private static String FOUR = "****************";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //건물으 층 수
        int N = Integer.parseInt(st.nextToken()); //한 층에 있는 창문 개수
        String[][] apartment = new String[(M * 5) + 1][(N * 5) + 1];

        for (int i = 0; i < apartment.length; i++) {
            String line = br.readLine();
            apartment[i] = line.split("");
        }

        Map<String, Integer> cases = new LinkedHashMap<>();
        cases.put(NOTHING, 0);
        cases.put(ONE, 0);
        cases.put(TWO, 0);
        cases.put(THREE, 0);
        cases.put(FOUR, 0);

        for (int i = 1; i < apartment.length; i += 5) {
            //i는 각 층의 맨 왼쪽 위 첫 창문임
            for (int j = 1; j < apartment[i].length; j += 5) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k < i + 4; k++) {
                    for (int p = j; p < j + 4; p++) {
                        sb.append(apartment[k][p]);
                    }
                }
                cases.put(sb.toString(), cases.get(sb.toString()) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : cases.values()) {
            sb.append(value).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
