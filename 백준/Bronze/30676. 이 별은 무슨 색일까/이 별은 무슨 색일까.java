import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lamda = Integer.parseInt(br.readLine());
        
        if(lamda>=620 && lamda <= 780) {
            System.out.println("Red");
        }
        else if(lamda >= 590 && lamda < 620) {
            System.out.println("Orange");
        }
        else if(lamda >= 570 && lamda < 590) {
            System.out.println("Yellow");
        }
        else if(lamda >= 495 && lamda < 570) {
            System.out.println("Green");
        }
        else if(lamda >= 450 && lamda < 495) {
            System.out.println("Blue");
        }
        else if(lamda >= 425 && lamda < 450) {
            System.out.println("Indigo");
        }
        else {
            System.out.println("Violet");
        }
    }
}