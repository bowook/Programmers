import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //I n 은 큐에 n을 삽입
        //D 1은 큐에 최대값 삭제
        //D -1은 큐에 최소값 삭제
        //큐가 비어있다면 D 연산은 무시
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i ++) {
            int Q = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for(int j = 0 ; j < Q; j ++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    //아, 이건 Map방식이니까, key가 Command로써 똑같으니까 계속 값이 대체가 되어버리는 상황이 발생하네
                    //키를 command로 하면 안됨
                    //해당 값이 중복으로 들어갈 수 있다고 하니까, value는 몇번나왔는지에 대한 카운트 값
                    treeMap.put(value, treeMap.getOrDefault(value,0)+1);
                }
                else if(command.equals("D")) {
                    if(treeMap.isEmpty()) {
                        continue;
                    }
                    int key = 0;
                    int count = 0;
                    if(value == 1) {
                        key = treeMap.lastKey();
                        count = treeMap.get(key);
                    }
                    else if(value == -1) {
                        key = treeMap.firstKey();
                        count = treeMap.get(key);
                    }
                    treeMap.remove(key);

                    if(count >= 2) {
                        treeMap.put(key, count-1);
                    }

                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            }
            else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}