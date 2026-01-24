import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numberMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int N = Integer.parseInt(nAndM[0]);
        int M = Integer.parseInt(nAndM[1]);

        for (int i = 1; i <= N; i ++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numberMap.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i ++) {
            String name = br.readLine();
            char firstChar = name.charAt(0);
            if (Character.isDigit(firstChar)) {
                sb.append(numberMap.get(Integer.parseInt(name)))
                    .append("\n");
                continue;
            }
            sb.append(nameMap.get(name))
                .append("\n");
        }

        System.out.println(sb);
    }
}

