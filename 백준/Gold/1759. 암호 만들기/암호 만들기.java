import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    private static int L, C;
    private static char[] word, password;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        word = new char[C];
        password = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            word[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(word);

        dfs(0, 0, 0, 0);
        System.out.print(sb);
    }

    static void dfs(int idx, int depth, int v, int c) {
        if (depth == L) {
            if (v >= 1 && c >= 2) {
                sb.append(password).append('\n');
            }
            return;
        }
        if (idx >= C) {
            return;
        }

        // 선택 ㅋㅋㄹㅃㅃ
        password[depth] = word[idx];
        if (vowels.contains(word[idx])) {
            dfs(idx + 1, depth + 1, v + 1, c);
        } else {
            dfs(idx + 1, depth + 1, v, c + 1);
        }
        
        // 선택 안함 ㅋㄹㅋ
        dfs(idx + 1, depth, v, c);
    }
}
