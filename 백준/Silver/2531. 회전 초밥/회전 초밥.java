import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //가장 좋아하는 초밥 먹음
        //초밥의 종류가 번호임
        //같은 종류의 초밥이 둘 이상 존재 할 수 있음

        //행사
        //임의의 한 위치 x부터 x+k개의 위치까지 연속으로 먹으면 할인된 가격 제공
        //초밥 종류 쿠폰 발행하고, 위 행사에 참여하면 하나 무료로 제공 -> 없으면 만들어서 제공

        //결국 그러면
        //가격 상관없이 최대한 많이 먹을 수 있는 초밥의 종류를 출력

        StringTokenizer st = new StringTokenizer(br.readLine());
        int placedDishes = Integer.parseInt(st.nextToken());
        int sushiTypes = Integer.parseInt(st.nextToken());
        int sequenceEatingDishes = Integer.parseInt(st.nextToken());
        int couponSushiNumber = Integer.parseInt(st.nextToken());

        int mid = placedDishes - sequenceEatingDishes + 1;
        List<Integer> placedSushiTypes = new ArrayList<>();
        for (int i = 0; i < placedDishes; i++) {
            int sushiType = Integer.parseInt(br.readLine());
            placedSushiTypes.add(sushiType);
        }

        int maxCount = 0;
        for (int i = 0; i < mid; i++) {
            int sushiType = placedSushiTypes.get(i);
            Set<Integer> eatingSushi = new HashSet<>();
            eatingSushi.add(sushiType);
            for (int j = i + 1; j < i + sequenceEatingDishes; j++) {
                eatingSushi.add(placedSushiTypes.get(j));
            }
            eatingSushi.add(couponSushiNumber);
            if (eatingSushi.size() > maxCount) {
                maxCount = eatingSushi.size();
            }
        }

        for (int i = mid; i < mid + sequenceEatingDishes - 1; i++) {
            int sushiType = placedSushiTypes.get(i);
            Set<Integer> eatingSushi = new HashSet<>();
            eatingSushi.add(sushiType);
            for (int j = 1; j < sequenceEatingDishes; j++) {
                if (i + j >= placedDishes) {
                    eatingSushi.add(placedSushiTypes.get(i + j - placedDishes));
                    continue;
                }
                eatingSushi.add(placedSushiTypes.get(i + j));
            }
            eatingSushi.add(couponSushiNumber);
            if (eatingSushi.size() > maxCount) {
                maxCount = eatingSushi.size();
            }
        }

        System.out.println(maxCount);
    }
}
