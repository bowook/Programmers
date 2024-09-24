import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String,Integer> generalMenu = new HashMap<>();
        HashMap<String,Integer> specialMenu = new HashMap<>();
        Set<String> serviceMenu = new HashSet<>();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < A; i ++) {
            st = new StringTokenizer(br.readLine());
            generalMenu.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < B; i ++) {
            st = new StringTokenizer(br.readLine());
            specialMenu.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < C; i ++) {
            st = new StringTokenizer(br.readLine());
            serviceMenu.add(st.nextToken());
        }

        int N = Integer.parseInt(br.readLine());
        long generalPrice = 0;
        long specialPrice = 0;
        long specialCount = 0;
        long serviceCount = 0;

        for(int i = 0; i < N; i ++) {
            String orderMenu = br.readLine();
            if(generalMenu.containsKey(orderMenu)) {
                generalPrice += generalMenu.get(orderMenu);
            }
            else if(specialMenu.containsKey(orderMenu)) {
                specialPrice += specialMenu.get(orderMenu);
                specialCount ++;
            }
            else {
                serviceCount ++;
            }
        }

        if((generalPrice < 20000 && specialCount > 0) ||
                (generalPrice + specialPrice < 50000 && serviceCount > 0) ||
                (serviceCount > 1)) {
            System.out.println("No");
        }
        else {
            System.out.println("Okay");
        }

    }
}