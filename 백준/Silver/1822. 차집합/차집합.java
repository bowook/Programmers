import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] aValues = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i ++) {
            aValues[i] = Integer.parseInt(st.nextToken());
        }
        int[] bValues = new int[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i ++) {
            bValues[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aValues);
        Arrays.sort(bValues);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int aValue : aValues) {
            boolean isIn = search(aValue, bValues);
            if (!isIn) {
                count ++;
                sb.append(aValue).append(" ");
            }
        }
        if (count == 0) {
            System.out.println(count);
            return;
        }
        System.out.println(count);
        System.out.println(sb.toString().trim());
    }

    private static boolean search(int aValue, int[] bValues) {
        int low = 0;
        int high = bValues.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (bValues[mid] == aValue) {
                return true;
            }
            else if (bValues[mid] > aValue) {
                high = mid - 1;
            }
            else if (bValues[mid] < aValue) {
                low = mid + 1;
            }
        }

        return false;
    }
}