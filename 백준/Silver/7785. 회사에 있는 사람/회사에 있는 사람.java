import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static final String LEAVE = "leave";
    private static final String ENTER = "enter";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> sets = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i ++) {
            String[] nameAndFlag = br.readLine().split(" ");
            String name = nameAndFlag[0];
            String flag = nameAndFlag[1];

            if (flag.equals(LEAVE)) {
                sets.remove(name);
                continue;
            }
            sets.add(name);
        }

        List<String> list = new ArrayList<>(sets);
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name)
                .append("\n");
        }

        System.out.println(sb);
    }
}

