import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int N = Integer.parseInt(arr[0]); //카드 개수
        int M = Integer.parseInt(arr[1]); //이 수에 가장 가까운 합을 구해야함!

        int[] cards = new int[N];

        String str2 = scanner.nextLine();
        String[] arr2 = str2.split(" ");
        for(int i = 0; i < N; i ++) {
            cards[i] = Integer.parseInt(arr2[i]);
        }

        int result = calculate(cards, M);

        System.out.println(result);


    }

    public static int calculate(int[] cards, int M){
        int maximum = 0;
        for(int i = 0; i < cards.length-2; i ++) {
            int sum = 0;
            for(int j = i + 1; j < cards.length-1; j++) {
                for(int k = j + 1; k < cards.length; k++) {
                    sum = cards[i] + cards[j] +cards[k];

                    if(sum <= M && sum > maximum) {
                        maximum = sum;
                    }
                }
            }
        }
        return maximum;
    }
}