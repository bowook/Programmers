import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //N kg임
        //봉지는 3kg, 5kg 두 종류
        //최대한 적은 봉지 && 정확하게 N kg 배달해야함

        Scanner scanner = new Scanner(System.in);


        int N = Integer.parseInt(scanner.nextLine());

        //N이 5로 나누어 떨어질 때
        //N이 최대한 5를 사용하고 3을 사용해서 나누어 떨어질 때
        //N이 3으로 나누어 떨어질 때
        //N이 나누어 떨어지지 않을 떄

        if(N%5 == 0) {
            //case 1
            System.out.println(N/5);
        }
        else {
            int count = 0;
            while(N > 0) {
                //일단 5로 나누었을 때 나머지가 0이 안됐으니까, 3 한봉지 줘야함
                count += 1;
                N -= 3;
                if(N%5 == 0) {
                    count += (N/5);
                    System.out.println(count);
                    break;
                }
                else if(N==0) {
                    //N이 3으로 나누어 떨어진거임
                    System.out.println(count);
                    break;
                }
                else if(N == 1 || N == 2) {
                    //N이 4가 나올 수 업음, 위에서 -3을 했으니까 4일경우에
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}