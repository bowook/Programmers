import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startSleepTime = scanner.nextInt();
        scanner.nextLine();

        int wakeUpTime = scanner.nextInt();
        scanner.nextLine();

        int totalSleepingTime = 24 - startSleepTime + wakeUpTime;

        if(startSleepTime == 0 || startSleepTime == 1 || startSleepTime == 2 || startSleepTime == 3) {
            totalSleepingTime = wakeUpTime - startSleepTime;
        }

        System.out.println(totalSleepingTime);
    }
}