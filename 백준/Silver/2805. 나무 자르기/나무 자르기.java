import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //높이 H보다 큰 나무는 H 위의 부분이 잘린다.
    //높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라감
    //한 줄에 연속해있는 나무를 모두 절단

    //출력해야하는 것은 절단기의 설정할 수 있는 최대 높이 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //나무 수
        int M = Integer.parseInt(st.nextToken()); //집으로 가져가려고 하는 나무 길이

        List<Integer> trees = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++) {
            trees.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(trees);

        int min = 0;
        int max = trees.get(trees.size()-1);

        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int i = 0; i < N; i ++) {

                if(trees.get(i) - mid > 0) {
                    sum += trees.get(i) - mid;
                }
            }
            if(sum < M) {

                max = mid;
            }

            else {
                //합이 더 크면 자라는 범위를 줄여야 하니까 min을 늘려야함
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }


}