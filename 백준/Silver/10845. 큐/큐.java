import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.remove());
                }
            }
            else if(command.equals("size")) {
                System.out.println(queue.size());
            }
            else if(command.equals("empty")) {
                if(queue.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else if(command.equals("front")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.peek());
                }
            }
            else if(command.equals("back")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    LinkedList<Integer> list = (LinkedList<Integer>) queue;
                    System.out.println(list.getLast());
                }
            }
        }

    }
}