import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i ++) {
            int value = Integer.parseInt(br.readLine());
            Map<String, Integer> closet = new HashMap<>();
            for (int j = 0; j < value; j ++) {
                String[] nameAndType = br.readLine().split(" ");
                String name = nameAndType[0];
                String type = nameAndType[1];
                closet.put(type, closet.getOrDefault(type, 0) + 1);
            }

            int sum = 1;
            for (int count : closet.values()) {
                sum *= (count + 1);
            }

            System.out.println(sum - 1);
        }
    }
}

