import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kAndL = br.readLine().split(" ");
        int K = Integer.parseInt(kAndL[0]);
        int L = Integer.parseInt(kAndL[1]);

        Set<String> students = new LinkedHashSet<>();
        for (int i = 0; i < L; i ++) {
            String studentNumber = br.readLine();
            if (students.contains(studentNumber)) {
                students.remove(studentNumber);
            }
            students.add(studentNumber);
        }

        List<String> list = new ArrayList<>(students);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i ++) {
            if (i >= list.size()) {
                break;
            }
            sb.append(list.get(i))
                .append("\n");
        }

        System.out.println(sb);
    }
}

