import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //카드는 순서대로 놓아져있음
        //마지막에 남는 카드 적기

        //음.. 큐 쓰자

        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < N; i ++) {
            queue.offer(i+1);
        }

        while(queue.size() != 1) {
            queue.remove();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());

    }
}