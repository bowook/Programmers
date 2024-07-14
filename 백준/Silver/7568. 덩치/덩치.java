import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        int[] weight = new int[N];
        int[] height = new int[N];

        for(int i = 0; i < N; i++) {
            String[] temp = scanner.nextLine().split(" ");
            weight[i] = Integer.parseInt(temp[0]);
            height[i] = Integer.parseInt(temp[1]);
        }

        int[] rank = ranks(weight, height);

        for(int i = 0; i < rank.length; i ++) {
            System.out.print(rank[i] + " ");
        }

    }

    public static int[] ranks(int[] weight, int[] height) {
        int length = weight.length;
        int[] result = new int[length];
        for(int i = 0; i < length; i ++) {
            int currentWeight = weight[i];
            int currentHeight = height[i];
            int rank = 0;
            for(int j = 0; j < length; j++) {
                if(currentWeight < weight[j] && currentHeight < height[j]) {
                    rank += 1;
                }
            }
            result[i] = rank + 1;

        }
        return result;
    }
}