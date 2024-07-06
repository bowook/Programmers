import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //호텔의 층 수, 각 층의 방 수, 몇 번째 손님
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testCase; i ++) {
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            String result = "";

            String first = stair(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]));
            String second = roomNumber(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]));

            if(second.length()==1) {
                result = result + first + "0" + second;
                System.out.println(result);
            }
            else {
                result = result + first + second;
                System.out.println(result);
            }

        }
    }

    public static String stair(int count, int human_number) {
        int stair = count;
        if(count < human_number) {
            stair = human_number - count;
            while(stair > count) {
                stair = stair - count;
            }
        }
        else if(count > human_number) {
            stair = human_number;
        }
        return String.valueOf(stair);
    }
    public static String roomNumber(int count, int human_number) {
        int room_number = 1;
        if(count < human_number) {
            int stair = human_number - count;
            while(stair > count) {
                stair = stair - count;
                room_number += 1;
            }
            room_number += 1;
        }
        return String.valueOf(room_number);
    }
}