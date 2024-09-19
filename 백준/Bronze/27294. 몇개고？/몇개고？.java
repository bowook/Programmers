import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // 시간
		int s = Integer.parseInt(st.nextToken()); // 술의 유무
		
		int result = 0;
	
		if (s == 1) {
			result = 280;
			
		} else {
			
			if (12 <= t && t <= 16) {
				result = 320;
				
			} else {
				result = 280;
			}
		}
		
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
}