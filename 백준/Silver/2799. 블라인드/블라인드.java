import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final String NOTHING = "................";
    private static final String ONE = "****............";
    private static final String TWO = "********........";
    private static final String THREE = "************....";
    private static final String FOUR = "****************";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int rows = M * 5 + 1;
        int cols = N * 5 + 1;
        char[][] apartment = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = br.readLine();
            for (int j = 0; j < cols; j++) {
                apartment[i][j] = line.charAt(j);
            }
        }

        Map<String, Integer> cases = new LinkedHashMap<>();
        cases.put(NOTHING, 0);
        cases.put(ONE, 0);
        cases.put(TWO, 0);
        cases.put(THREE, 0);
        cases.put(FOUR, 0);

        for (int i = 1; i < rows; i += 5) {
            for (int j = 1; j < cols; j += 5) {
                StringBuilder sb = new StringBuilder(16);
                for (int k = i; k < i + 4; k++) {
                    for (int p = j; p < j + 4; p++) {
                        sb.append(apartment[k][p]);
                    }
                }
                String patStr = sb.toString();
                cases.put(patStr, cases.getOrDefault(patStr, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int count : cases.values()) {
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
