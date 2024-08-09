import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static HashMap<Integer,Integer> visited = new HashMap<>();
    private static int[] coordinates;
    public static void main(String[] args) throws IOException {
        //좌표 압축
        //Ranking List 문제임!!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        coordinates = new int[N];

        ArrayList<Integer> sortedCoordinates = new ArrayList<>();
        for(int i = 0; i < N; i ++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
            sortedCoordinates.add(coordinates[i]);
        }

        Collections.sort(sortedCoordinates);

        int rank = 0;

        for(int coordinate : sortedCoordinates) {
            if(!visited.containsKey(coordinate)) {
                visited.put(coordinate,rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++) {
            sb.append(visited.get(coordinates[i])).append(" ");
        }

        System.out.println(sb);

    }
}