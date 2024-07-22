import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> list = new HashSet<>();
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                if(list.contains(x)) {
                    continue;
                }
                //없는경우니까
                list.add(x);
            }
            else if(command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                //정수타입으로 하면 인덱스로 인식을 하니까, String으로 바꿔서 수정해봐야겠다.
                if(!list.contains(x)){
                    continue;
                }
                list.remove(x);
            }
            else if(command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if(list.contains(x)) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if(command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if(list.contains(x)) {
                    list.remove(x);
                }
                else {
                    list.add(x);
                }
            }
            else if(command.equals("all")) {
                list.clear();
                for(int j = 1; j <= 20; j ++) {
                    list.add(j);
                }
            }
            else if(command.equals("empty")) {
                list.clear();
            }
        }

        System.out.println(sb);

    }
}