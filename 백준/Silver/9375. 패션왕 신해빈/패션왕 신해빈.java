import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, List<String>> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String part = st.nextToken(); // 의상의 이름
                String type = st.nextToken(); // 의상의 종류

                // 의상의 종류에 따라 리스트에 추가
                map.computeIfAbsent(type, k -> new ArrayList<>()).add(part);
            }

            int combinations = 1; // 기본값 1로 시작
            for (String key : map.keySet()) {
                int listSize = map.get(key).size();
                combinations *= (listSize + 1); // 각 종류에서 선택할 수 있는 경우의 수
            }

            // 아무 의상도 입지 않는 경우를 제외
            combinations -= 1;

            System.out.println(combinations);

            map.clear();
        }
    }
}