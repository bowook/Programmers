import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        int sum = 0;

        for(int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
            frequencyMap.put(numbers[i], frequencyMap.getOrDefault(numbers[i], 0) + 1);
        }

        int frequencyKey = numbers[0];
        int count = 0;

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() > count) {
                count = entry.getValue();
                frequencyKey = entry.getKey();
            }
            //여기서 최빈 값의 key와 몇 번 count되었는지를 알 수 있음
        }

        //그럼 이제 해당 count만큼 가진애들끼리애서 두번쨰로 작은 값을 가져오면 됨
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() == count) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        if(list.size() == 1) {
            frequencyKey = list.get(0);
        }
        else {
            frequencyKey = list.get(1);
        }
        Arrays.sort(numbers);

        System.out.println((int) Math.round((double) sum / N));

        System.out.println(numbers[N/2]);
        System.out.println(frequencyKey);
        System.out.println(numbers[N-1] - numbers[0]);



    }
}