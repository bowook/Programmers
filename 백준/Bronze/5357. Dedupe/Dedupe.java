import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lineNumber; i++) {
            String line = br.readLine();
            if (line.isEmpty()) {
                sb.append("\n");
                continue;
            }

            char previousChar = line.charAt(0);
            sb.append(previousChar);

            for (int j = 1; j < line.length(); j++) {
                char currentChar = line.charAt(j);
                if (currentChar != previousChar) {
                    sb.append(currentChar);
                    previousChar = currentChar;
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}