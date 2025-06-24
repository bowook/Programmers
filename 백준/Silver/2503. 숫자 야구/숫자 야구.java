import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int candidate = 0;

        int[][] totalInputs = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] inputs = new int[5];
            int[] numbers = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            inputs[0] = numbers[0];
            inputs[1] = numbers[1];
            inputs[2] = numbers[2];
            inputs[3] = Integer.parseInt(st.nextToken());
            inputs[4] = Integer.parseInt(st.nextToken());

            totalInputs[i] = inputs;
        }

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    int possibility = 0;
                    for (int p = 0; p < N; p++) {
                        int strike = 0;
                        int ball = 0;
                        int[] input = totalInputs[p];

                        if (input[0] == i) {
                            strike++;
                        } else if (input[0] == j || input[0] == k) {
                            ball++;
                        }

                        if (input[1] == j) {
                            strike++;
                        } else if (input[1] == i || input[1] == k) {
                            ball++;
                        }

                        if (input[2] == k) {
                            strike++;
                        } else if (input[2] == i || input[2] == j) {
                            ball++;
                        }

                        if (strike == input[3] && ball == input[4]) {
                            possibility++;
                        }
                    }

                    if (possibility == N) {
                        candidate++;
                    }
                }
            }
        }

        System.out.println(candidate);
    }
}
