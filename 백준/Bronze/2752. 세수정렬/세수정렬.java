import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();
        final int[] values = Arrays.stream(br.readLine().split(SPACE))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(values);
        for (int value : values) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
