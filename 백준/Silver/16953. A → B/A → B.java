import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int B;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[B+1];

        int result = bfs(A, 1); //최솟값에 1을 더해야하니까 그냥 1을 전달해줬음

        System.out.println(result);
    }

    private static int bfs(int number, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{number, count});
        visited[number] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNumber = current[0];
            int currentCount = current[1];

            if(currentNumber == B) {
                return currentCount;
            }

            long newNumber = currentNumber * 2L; // *2를 해도 20억이라, 21억 미만이니까 정수형 맞는데, 왜 넘버포맷 오류가 나지
            if(newNumber <= B && !visited[(int)newNumber]) {
                queue.offer(new int[]{(int)newNumber, currentCount+1});
                visited[(int)newNumber] = true;
            }
            //아 여기서, 10억일경우 101억이 되버릴 수 있음, 그러면 포맷 에러가 발생하네
            //newNumber = Integer.parseInt(String.valueOf(currentNumber) + "1");
            newNumber = Long.parseLong(String.valueOf(currentNumber) + "1");
            if(newNumber <= B && !visited[(int)newNumber]) {
                queue.offer(new int[]{(int)newNumber,currentCount+1});
                visited[(int)newNumber] = true;
            }
        }
        return -1;
    }
}