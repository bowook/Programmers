import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int sLength = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringBuilder result = new StringBuilder(s);
            boolean changed;
            do {
                changed = false;
                StringBuilder temp = new StringBuilder();

                for (int j = 0; j < result.length(); j++) {
                    temp.append(result.charAt(j));
                    
                    if (temp.length() >= 3 && temp.substring(temp.length() - 3).equals("ABB")) {
                        temp.setLength(temp.length() - 3);
                        temp.append("BA");
                        changed = true; 
                    }
                }

                result = temp; 
            } while (changed);

            sb.append(result.toString()).append("\n");
        }
        br.close();
        System.out.print(sb.toString());
    }
}