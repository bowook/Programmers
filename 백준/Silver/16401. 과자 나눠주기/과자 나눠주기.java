import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] snackSizes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            snackSizes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snackSizes);

        int counts = searchBinary(M, snackSizes);

        System.out.println(counts);
    }

    private static int searchBinary(int M, int[] snackSizes) {
        int base = 1;
        int high = snackSizes[snackSizes.length - 1];
        int result = 0;

        while (base <= high) {
            int mid = (base + high) / 2;

            if (check(M, mid, snackSizes)) {
                //다 줄 수 있으니까 
                base = mid + 1;
                result = mid;
            }
            else {
                //다 못 줘.
                high = mid - 1;
            }
        }

        return result;
    }

    private static boolean check(int M, int tempSnackSize, int[] snackSizes) {
        int sum = 0;
        
        for (int snackSize : snackSizes) {
            sum += snackSize / tempSnackSize;

            if (sum >= M) {
                return true;
            }
        }
        return false;
    }
}