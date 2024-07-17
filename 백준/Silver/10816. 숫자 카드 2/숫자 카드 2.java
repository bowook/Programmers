import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //N은 상근이가 가지고 있는 수자 카드의 개수
        int N = Integer.parseInt(scanner.nextLine());
        //둘째 줄에는 상근이 가지고 있는 숫자 카드들
        String[] temp = scanner.nextLine().split(" ");
        int[] cards = new int[temp.length];

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < cards.length; i ++) {
            cards[i] = Integer.parseInt(temp[i]);
            map.put(cards[i], map.getOrDefault(cards[i],0) + 1);
        }

        int M = Integer.parseInt(scanner.nextLine());
        String[] temp2 = scanner.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(temp2[i]);
            result.append(map.getOrDefault(target, 0)).append(" ");
        }

        System.out.println(result.toString().trim());

    }
}