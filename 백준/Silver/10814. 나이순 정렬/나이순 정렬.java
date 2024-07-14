import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Map<Integer,String>> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < N; i ++) {
            Map<Integer, String> map = new HashMap<>();
            String[] arr = scanner.nextLine().split(" ");
            map.put(Integer.parseInt(arr[0]), arr[1]);

            list.add(map);
        }
        list.sort(new Comparator<Map<Integer, String>>() {
            @Override
            public int compare(Map<Integer, String> o1, Map<Integer, String> o2) {
                Integer age1 = o1.keySet().iterator().next();
                Integer age2 = o2.keySet().iterator().next();
                return age1.compareTo(age2);
            }
        });

        for(Map<Integer, String> map : list) {
            Integer age = map.keySet().iterator().next();
            String name = map.get(age);
            System.out.println(age + " " + name);
        }
    }
}