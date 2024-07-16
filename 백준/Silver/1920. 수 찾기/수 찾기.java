import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>();
        String[] arr = scanner.nextLine().split(" ");
        for(int i = 0; i < N; i ++) {
            list.add(Integer.parseInt(arr[i]));
        }

        //이진 탐색 사용해야겠다,, 흠..
        //그러면 정렬이 필요함!

        Collections.sort(list);

        int M = Integer.parseInt(scanner.nextLine());
        String[] arr2 = scanner.nextLine().split(" ");

        for(int i = 0; i < M; i ++) {
            int target = Integer.parseInt(arr2[i]);
            if(binarySearch(list,target)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }

    public static boolean binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size()-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = list.get(mid);

            if(midElement == target) {
                return true;
            }
            else if (midElement > target) {
                right = mid -1;
            }
            else if (midElement < target) {
                left = mid + 1;
            }
        }

        return false;
    }
}
