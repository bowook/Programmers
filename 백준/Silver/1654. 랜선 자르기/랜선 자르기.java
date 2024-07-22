import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //N개의 랜선 (같은 길이)
        //영식이는 자체적으로 K개의 랜선을 가지고 있다. (길이 다 제각각)

        //그래서 K개의 랜선을 이용해 같은 길이의 랜선을 만들어야함

        //센티미터 단위 정수 길이

        //N개의 랜선을 만들 수 있는 최대 랜선의 길이를 구하기


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[K];
        long min = 0;
        long mid = 0;
        long max = 0;
        long count;
        for(int i = 0; i < K; i ++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if(numbers[i] >= max) {
                max = numbers[i];
            }
        }

        max += 1;
        Arrays.sort(numbers);

        while(min < max) {
            count = 0;
            mid = (max+min) / 2;
            for(int i = 0; i < K; i ++) {
                count += numbers[i]/mid;
            }

            if(count < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min-1);




    }
}
