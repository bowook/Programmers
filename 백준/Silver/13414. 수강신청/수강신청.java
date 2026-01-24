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
            students.remove(studentNumber);
            students.add(studentNumber);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String student : students) {
            if (count == K) {
                break;
            }
            sb.append(student)
                .append("\n");
            count ++;
        }

        System.out.println(sb);
    }
}

