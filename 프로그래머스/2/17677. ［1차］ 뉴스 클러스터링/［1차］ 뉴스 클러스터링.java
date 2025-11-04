import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1List = init(str1);
        List<String> str2List = init(str2);
        List<String> intersection = new ArrayList<>();
        
        if (str1List.isEmpty() && str2List.isEmpty()) {
            return 65536;
        }
        
        List<String> temp = new ArrayList<>(str1List);
        for (String str : str2List) {
            if (temp.remove(str)) {
                intersection.add(str);
            }
        }
        int unionSize = str1List.size() + str2List.size() - intersection.size();
        double jaccard = (double) intersection.size() / unionSize;

        return (int) (jaccard * 65536);
    }
    
    private List<String> init(String str) {
        List<String> list = new ArrayList<>();
        String lowerStr = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i ++) {
            char first = lowerStr.charAt(i);
            char second = lowerStr.charAt(i+1);
            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                list.add("" + first + second);
            }
        }
        
        return list;
    }
}