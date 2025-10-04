import java.util.*;

class Solution {
    public boolean solution(final String[] phone_book) {
        Set<String> phoneNumbers = new HashSet<>(Arrays.asList(phone_book));
        
        for (String number : phoneNumbers) {
            for (int i = 1; i < number.length(); i++) {
                if (phoneNumbers.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}