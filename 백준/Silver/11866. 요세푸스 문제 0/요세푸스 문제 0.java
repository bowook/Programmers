import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tempArr = scanner.nextLine().split(" ");

        int N = Integer.parseInt(tempArr[0]);
        int K = Integer.parseInt(tempArr[1]);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i ++) {
            queue.offer(i+1);
        }
        while(list.size() != N) {
            for(int i = 0; i < K-1; i++) {
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }
        System.out.print("<");
        for(int i = 0; i < N; i++) {
            if(i == N - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
        System.out.print(">");
    }
}