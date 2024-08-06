import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();

        // -로 나눔 
        //이거인듯 걍, -로 다 나누고 부분합 다 구해서 마이너스
        String[] splitMinus = formula.split("-");
        int result = 0;

        // 첫 번째 - 부분 이전은 다 더함 
        for (String part : splitMinus[0].split("\\+")) {
            result += Integer.parseInt(part);
        }

        // 나머지 부분은 걍 각각 더해서 -해줌
        for (int i = 1; i < splitMinus.length; i++) {
            int tempSum = 0;
            for (String part : splitMinus[i].split("\\+")) {
                tempSum += Integer.parseInt(part);
            }
            result -= tempSum;
        }

        System.out.println(result);
    }
}