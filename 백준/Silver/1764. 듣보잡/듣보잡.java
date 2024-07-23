import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> noSeeMap = new HashMap<>();
        List<String> names = new ArrayList<>();

        for(int i = 0; i < N; i ++) {
            noSeeMap.put(br.readLine(), i);
        }

        for(int i = 0; i < M; i ++) {
            String name = br.readLine();

            if(noSeeMap.containsKey(name)) {
                names.add(name);
            }
        }

        Collections.sort(names);
        StringBuilder sb = new StringBuilder();
        int nameSize = names.size();
        sb.append(nameSize).append("\n");

        for(int i = 0; i < nameSize; i ++) {
            sb.append(names.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}