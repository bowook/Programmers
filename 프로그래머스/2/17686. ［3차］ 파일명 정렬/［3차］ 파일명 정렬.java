import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1,f2) -> {
            String f1Head = extractHead(f1);
            String notContainsF1Head = extractNotContainsHead(f1, f1Head);
            String f1Numbers = extractNumber(notContainsF1Head);
            String f1Tails = extractTails(notContainsF1Head, f1Numbers);
            
            String f2Head = extractHead(f2);
            String notContainsF2Head = extractNotContainsHead(f2, f2Head);
            String f2Numbers = extractNumber(notContainsF2Head);
            String f2Tails = extractTails(notContainsF2Head, f2Numbers);
        
            int isSame = f1Head.toLowerCase().compareTo(f2Head.toLowerCase());
            if (isSame != 0) {
                return isSame;
            }
            
            //숫자로 정렬 해야함
            int parsedF1Number = Integer.parseInt(f1Numbers);
            int parsedF2Number = Integer.parseInt(f2Numbers);
            
            return parsedF1Number - parsedF2Number;
        });
        
        return files;
    }
    
    private String extractTails(final String numberAndTail, final String number) {
        return numberAndTail.substring(number.length());
    }
    
    private String extractNumber(final String numberAndTail) {
        String numbers = "";
        for (char c : numberAndTail.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers += c;
                continue;
            }
            break;
        }
        
        return numbers;
    }
    
    private String extractNotContainsHead(final String file, final String head) {
        return file.substring(head.length());
    }
    
    private String extractHead(final String file) {
        return file.split("[0-9]")[0];
    }
}
