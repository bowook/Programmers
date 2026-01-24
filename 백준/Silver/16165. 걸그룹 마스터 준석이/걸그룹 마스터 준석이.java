import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int N = Integer.parseInt(nAndM[0]);
        int M = Integer.parseInt(nAndM[1]);

        Map<String, List<String>> teamMap = new HashMap<>();
        for (int i = 0; i < N; i ++) {
            String teamName = br.readLine();
            int teamNumbers = Integer.parseInt(br.readLine());
            for (int j = 0; j < teamNumbers; j ++) {
                String name = br.readLine();
                teamMap.computeIfAbsent(teamName, k -> new ArrayList<>()).add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M ; i ++) {
            String nameOrTeamName = br.readLine();
            int number = Integer.parseInt(br.readLine());
            if (teamMap.containsKey(nameOrTeamName) && number == 0) {
                List<String> names = teamMap.get(nameOrTeamName);
                Collections.sort(names);
                for (String name : names) {
                    sb.append(name)
                        .append("\n");
                }

                continue;
            }

            for (Map.Entry<String, List<String>> entry : teamMap.entrySet()) {
                String teamName = entry.getKey();
                List<String> names = entry.getValue();
                if (names.contains(nameOrTeamName)) {
                    sb.append(teamName)
                        .append("\n");
                }
            }
        }
        System.out.println(sb.toString().trim());
        
    }
}
