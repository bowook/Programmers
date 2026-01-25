import java.util.*;
import java.io.*;

class Main {

    private static final int PRESENCE = 1;
    private static final int NOT_PRESENCE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i ++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i ++) {
            int value = Integer.parseInt(st.nextToken());
            sb.append(search(list, value))
                .append("\n");
        }

        System.out.println(sb);
    }

    private static int search(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == list.get(mid)) {
                return PRESENCE;
            }
            else if (target > list.get(mid)) {
                low = mid + 1;
                continue;
            }
            else if (target < list.get(mid)) {
                high = mid - 1;
                continue;
            }
        }

        return NOT_PRESENCE;
    }
}