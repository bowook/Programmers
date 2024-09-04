import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < N; i ++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j ++) {
                int number = Integer.parseInt(st.nextToken());
                list.get(i).add(number);
            }
        }

        for(int i = 1; i < N; i ++) {
            int colum = i + 1; // 1행부터니까, 1행에 2 col 존재
            for(int j = 0; j < colum; j ++) {
                if(j == 0) {
                    //가장 자리 부분은 따로 비교 할 필요가 없는 부분합임
                    list.get(i).set(j, list.get(i).get(j) + list.get(i-1).get(j));
                    continue;
                }
                else if(j == colum -1) {
                    list.get(i).set(j, list.get(i).get(j) + list.get(i-1).get(colum-2));
                    continue;
                }
                list.get(i).set(j, Math.max(list.get(i).get(j) + list.get(i-1).get(j-1), list.get(i).get(j) + list.get(i-1).get(j)));
            }
        }
        int maxNumber = list.get(N-1).get(0);
        for(int i = 1; i < N; i ++) {
            if(list.get(N-1).get(i) > maxNumber) {
                maxNumber = list.get(N-1).get(i);
            }
        }
        System.out.println(maxNumber);
    }
}