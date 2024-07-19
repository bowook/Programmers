import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //우선순위 큐 느낌이군..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        //첫번째는 문서의 개수
        //두번째는 궁금한 문서의 몇 번쨰
        //세번째는 중요도 순서
        for(int i = 0; i < testCase; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int documents = Integer.parseInt(st.nextToken());
            int curiousDocument = Integer.parseInt(st.nextToken());

            String[] str = br.readLine().split(" ");

            Queue<Integer> indexQueue = new LinkedList<>();
            Queue<Integer> priorityQueue = new LinkedList<>();

            for(int j = 0; j < documents; j ++) {
                priorityQueue.offer(Integer.parseInt(str[j]));
                indexQueue.offer(j);
            }

            int count = 0;

            while(!priorityQueue.isEmpty()) {
                int currentPriority = priorityQueue.poll();
                int currentIndex = indexQueue.poll();

                boolean hasHigherPriority = false;

                for(int priority : priorityQueue) {
                    if(priority > currentPriority) {
                        hasHigherPriority = true;
                        break;
                        //발견한 순간 더 조사할 필요 없으니까 break하고
                    }
                }

                if(hasHigherPriority) {
                    indexQueue.offer(currentIndex);
                    priorityQueue.offer(currentPriority);
                }
                else {
                    //그러면 한번 출력했다고 가정
                    count += 1;
                    if(currentIndex == curiousDocument) {
                        System.out.println(count);
                        break;
                    }

                }
            }
        }
    }
}