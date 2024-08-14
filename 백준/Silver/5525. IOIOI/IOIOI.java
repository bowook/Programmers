import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //I가 N+1개, O가 N개
        int M = Integer.parseInt(br.readLine()); //S의 길이
        String S = br.readLine(); //문자열 S

        String pattern = createPattern(N);
        int[] table = computeTable(pattern);
        int count = kmpSearch(S, pattern, table);

        System.out.println(count);
    }
    private static String createPattern(int N) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append("IO");
        }

        sb.append("I");

        return sb.toString();
    }

    private static int[] computeTable(String pattern) {
        int[] table = new int[pattern.length()];
        int cuurentPrefixLength = 0;
        for(int currentSuffix = 1; currentSuffix < pattern.length(); currentSuffix ++) { //패턴의 두번째 문자부터 시작
            while(cuurentPrefixLength > 0 && pattern.charAt(currentSuffix) != pattern.charAt(cuurentPrefixLength)) {
                cuurentPrefixLength = table[cuurentPrefixLength-1];
                //불일치가 발생하면 cuurentPrefixLength를 table 배열에 따라 이동
            }
            if(pattern.charAt(currentSuffix) == pattern.charAt(cuurentPrefixLength)) {
                table[currentSuffix] = ++cuurentPrefixLength;
                //일치하면 cuurentPrefixLength를 증가시키고 배열에 저장
            }
        }

        return table;
    }

    private static int kmpSearch(String text, String pattern, int[] table) {
        int count = 0;
        int j = 0; // 패턴의 인덱스
        for (int i = 0; i < text.length(); i++) { // 텍스트의 각 문자에 대해
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1]; // 불일치 시 패턴의 인덱스를 table에 따라 이동
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    count++; // 패턴이 발견됨
                    j = table[j]; // 다음 패턴 탐색을 위해 인덱스 조정
                } else {
                    j++; // 일치하면 j를 증가
                }
            }
        }
        return count;
    }
}