import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {-1, 1},
            {-1, -1},
            {1, 1},
            {1, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        String[][] coordinate = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                coordinate[i][j] = inputs[j];
            }
        }

        int[][] handshakeCounts = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                //사람이 앉아 있는 자리임
                for (int[] direction : directions) {
                    int newRow = i + direction[0];
                    int newCol = j + direction[1];

                    if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col || coordinate[newRow][newCol].equals(
                            ".")) {
                        // 악수 못함
                        continue;
                    }
                    if (coordinate[newRow][newCol].equals("o")) {
                        count += 1;
                    }

                }
                handshakeCounts[i][j] = count;
            }
        }

        int totalHandshakes = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (coordinate[i][j].equals("o")) {
                    totalHandshakes += handshakeCounts[i][j];
                }
            }
        }
        totalHandshakes /= 2;

        int maxAdditionalHandshakes = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (coordinate[i][j].equals(".")) {
                    int count = 0;
                    for (int[] direction : directions) {
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];
                        if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                            if (coordinate[newRow][newCol].equals("o")) {
                                count++;
                            }
                        }
                    }
                    if (count > maxAdditionalHandshakes) {
                        maxAdditionalHandshakes = count;
                    }
                }
            }
        }

        int maxTotalHandshakes = totalHandshakes + maxAdditionalHandshakes;
        System.out.println(maxTotalHandshakes);
    }
}
