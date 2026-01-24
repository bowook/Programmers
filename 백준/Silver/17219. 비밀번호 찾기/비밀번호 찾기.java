import java.util.*;
import java.io.*;

class Main {

    private static final String EMPTY = " ";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(EMPTY);
        int N = Integer.parseInt(nAndM[0]);
        int M = Integer.parseInt(nAndM[1]);

        Map<String, String> database = new HashMap<>();
        for (int i = 0; i < N; i ++) {
            String[] addressAndPassword = br.readLine().split(EMPTY);
            String address = addressAndPassword[0];
            String password = addressAndPassword[1];

            database.put(address, password);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i ++) {
            String address = br.readLine();
            sb.append(database.get(address))
                .append("\n");
        }

        System.out.println(sb);
    }
}

