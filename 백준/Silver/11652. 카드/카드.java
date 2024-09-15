import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Long,Long> hashMap = new HashMap<>();
        List<Long> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++) {
            long input = Long.parseLong(br.readLine());
            hashMap.put(input, hashMap.getOrDefault(input,0L)+1);
        }

        long maxValue = Collections.max(hashMap.values());

        for(long key : hashMap.keySet()) {
            if(hashMap.get(key) == maxValue) {
                list.add(key);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}