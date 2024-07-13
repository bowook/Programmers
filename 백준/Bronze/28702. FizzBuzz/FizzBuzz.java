import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //i가 3의 배수 && i가 5의 배수 = "FizzBuzz"
        //i가 3의 배수 && i가 != 5의 배수 = "Fizz"
        //i가 != 3의 배수 && i가 5의 배수 = "Buzz"
        //i가 != 3의 배수 && i가 != 5의 배수 = i

        Scanner scanner = new Scanner(System.in);

        int lastNumber = 0;
        int index = 0;
        for(int i = 0; i < 3; i++) {
            String str = scanner.nextLine();
            if(Character.isDigit(str.charAt(0))) {
                lastNumber = Integer.parseInt(str);
                index = i;
            }
        }
        if(index == 0) {
            index = 3;
        }
        else if (index == 1) {
            index = 2;
        }
        else if(index == 2) {
            index = 1;
        }
        lastNumber = lastNumber + index;

        if(lastNumber % 3 ==0 && lastNumber % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (lastNumber % 3 == 0 && lastNumber % 5 != 0) {
            System.out.println("Fizz");
        } else if (lastNumber %3 != 0 && lastNumber % 5 == 0) {
            System.out.println("Buzz");
        } else if (lastNumber %3 != 0 && lastNumber % 5 != 0) {
            System.out.println(lastNumber);
        }

    }
}