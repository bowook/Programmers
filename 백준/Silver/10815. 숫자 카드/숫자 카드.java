import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] targetCards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i ++) {
            targetCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();
        for (int targetCard : targetCards) {
            int counts = search(cards, targetCard);
            sb.append(counts)
                .append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static int search(int[] cards, int targetCard) {
        int base = 0;
        int high = cards.length - 1;

        while (base <= high) {
            int mid = (base + high) / 2;

            if (cards[mid] == targetCard) {
                return 1;
            }
            else if (cards[mid] > targetCard) {
                high = mid - 1;
            }
            else if (cards[mid] < targetCard) {
                base = mid + 1;
            }
        }

        return 0;
    }
}