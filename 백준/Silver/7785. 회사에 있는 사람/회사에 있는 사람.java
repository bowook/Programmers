import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final String LEAVE = "leave";
    private static final String ENTER = "enter";
    
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i ++) {
            String[] nameAndFlag = br.readLine().split(" ");
            String name = nameAndFlag[0];
            String flag = nameAndFlag[1];
            
            if (flag.equals("leave")) {
                map.remove(name);
                continue;
            }
            map.put(name, flag);
        }

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(key);
        }

        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0; i --) {
            System.out.println(list.get(i));
        }
    }
}

