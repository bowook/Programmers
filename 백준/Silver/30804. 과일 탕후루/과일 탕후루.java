
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> fruits = new ArrayDeque<>();
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int maxFruits = 0;

        for (int i = 0; i < N; i++) {
            int fruitNumber = Integer.parseInt(st.nextToken());
            fruits.add(fruitNumber);
            fruitCount.put(fruitNumber, fruitCount.getOrDefault(fruitNumber, 0) + 1);

            // 과일 종류가 3개 이상이 되면 가장 오래된 과일을 제거
            while (fruitCount.size() > 2) {
                int removedFruit = fruits.pollFirst();
                fruitCount.put(removedFruit, fruitCount.get(removedFruit) - 1);
                if (fruitCount.get(removedFruit) == 0) {
                    fruitCount.remove(removedFruit);
                }
            }

            // 현재까지의 최대 과일 개수를 갱신
            maxFruits = Math.max(maxFruits, fruits.size());
        }

        System.out.println(maxFruits);
    }
}
