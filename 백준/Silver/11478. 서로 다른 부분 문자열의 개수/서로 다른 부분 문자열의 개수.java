import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splittedS = br.readLine().split("");
        Set<String> sets = new HashSet<>();

        for (int i = 0; i < splittedS.length; i ++) {
            String str = splittedS[i];
            sets.add(str);
            for (int j = i + 1; j < splittedS.length; j ++) {
                str += splittedS[j];
                sets.add(str);
            }
        }

        System.out.println(sets.size());
    }
}

