import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startPoint = br.readLine().split("");
        int row = Integer.parseInt(startPoint[1]); //숫자
        int col = converter(startPoint[0]); //알파벳

        boolean[][] board = new boolean[7][7];
        board[row][col] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(col);
        stack.push(row);

        for (int i = 0; i < 35; i++) {
            String[] movePoint = br.readLine().split("");
            int moveRow = Integer.parseInt(movePoint[1]);
            int moveCol = converter(movePoint[0]);

            if (board[moveRow][moveCol]) {
                System.out.println("Invalid");
                return;
            }

            int isRowMovable = Math.abs(moveRow - stack.pop());
            int isColMovable = Math.abs(moveCol - stack.pop());
            if (!(isRowMovable == 1 && isColMovable == 2) && !(isRowMovable == 2 && isColMovable == 1)) {
                System.out.println("Invalid");
                return;
            }
            stack.push(moveCol);
            stack.push(moveRow);

            board[moveRow][moveCol] = true;
            if (i == 34) {
                int isFirstRowMovable = Math.abs(moveRow - row);
                int isFirstColMovable = Math.abs(moveCol - col);
                if (!(isFirstRowMovable == 1 && isFirstColMovable == 2) && !(isFirstRowMovable == 2
                        && isFirstColMovable == 1)) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }
        System.out.println("Valid");

    }

    private static int converter(final String alphabet) {
        switch (alphabet) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            case "E":
                return 5;
            default:
                return 6;
        }
    }
}
