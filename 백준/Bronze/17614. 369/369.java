import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();

        int clapCount = 0;
        for(int i = 1; i <= Long.parseLong(N); i ++) {
            String[] arr = String.valueOf(i).split("");

            for(int j = 0; j < arr.length; j ++) {

                if(Integer.parseInt(arr[j]) != 0 && Integer.parseInt(arr[j])% 3 == 0) {
                    clapCount += 1;
                }
            }
        }
        sb.append(clapCount);
        System.out.println(sb);

    }
}