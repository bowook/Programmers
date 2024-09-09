import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //돌 개수

        bw.write((N % 2 == 1) ? "CY" : "SK");
        bw.flush();
        bw.close();
        br.close();
    }
}