import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String p = scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
            String input = scanner.nextLine();

            if (n == 0 && p.contains("D")) {
                System.out.println("error");
                continue;
            } else if (n == 0) {
                System.out.println("[]");
                continue;
            }

            String[] stringNumbers = input.replaceAll("\\[|\\]", "").split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            for (String str : stringNumbers) {
                deque.add(Integer.parseInt(str.trim()));
            }

            boolean isReversed = false;
            boolean flag = false;

            for (char func : p.toCharArray()) {
                if (func == 'R') {
                    isReversed = !isReversed;
                } else if (func == 'D') {
                    if (deque.isEmpty()) {
                        flag = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if (flag) {
                System.out.println("error");
            } else {
                StringBuilder result = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    if (isReversed) {
                        result.append(deque.removeLast());
                    } else {
                        result.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) {
                        result.append(",");
                    }
                }
                result.append("]");
                System.out.println(result.toString());
            }
        }
        scanner.close();
    }
}