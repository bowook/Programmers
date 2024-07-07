import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 참가자 수
        int customer = scanner.nextInt();
        scanner.nextLine();

        // 티셔츠 사이즈별 신청 인원
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] sizeByCustomers = new int[arr.length];
        for(int i = 0; i < sizeByCustomers.length; i ++) {
            sizeByCustomers[i] = Integer.parseInt(arr[i]);
        }

        // 티셔츠 묶음 수와 펜 묶음 수
        str = scanner.nextLine();
        arr = str.split(" ");
        int T = Integer.parseInt(arr[0]);
        int P = Integer.parseInt(arr[1]);

        // 티셔츠 묶음 수 계산
        int totalShirts = 0;
        for(int i = 0; i < sizeByCustomers.length; i ++) {
            totalShirts += sizeByCustomers[i];
        }

        int shirtBundles = 0;
        for(int i = 0; i < sizeByCustomers.length; i++) {
            shirtBundles += (sizeByCustomers[i] + T - 1) / T;
        }

        // 펜 묶음 수 계산
        int penBundles = customer / P;
        int remainingPens = customer % P;

        // 결과 출력
        System.out.println(shirtBundles);
        System.out.println(penBundles + " " + remainingPens);
    }
}
