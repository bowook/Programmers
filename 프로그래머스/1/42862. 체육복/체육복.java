import java.util.*;

class Solution {
    public int solution(int n, int[] losts, int[] reserves) {
        //먼저, 제공해줄 수 있는 애들과, 잃어버린 애들을 한 번 정리해야함.
        Arrays.sort(losts);
        Arrays.sort(reserves);
        for (int i = 0; i < losts.length; i ++) {
            for (int j = 0; j < reserves.length; j ++) {
                if (losts[i] == reserves[j]) {
                    losts[i] = -2;
                    reserves[j] = -2;
                    break;
                }
            }
        }

        for (int i = 0; i < losts.length; i ++) {
            int lost = losts[i];
            if (lost <= -1) {
                continue;
            }
            for (int j = 0; j < reserves.length; j ++) {
                int reserve = reserves[j];
                if (reserve <= -1) {
                    continue;
                }
                
                if (lost - 1 == reserve || lost + 1 == reserve) {
                    losts[i] = -1;
                    reserves[j] = -1;
                    break;
                }
            }       
        }
        
        for (int i = 0; i < losts.length; i ++) {
            int lost = losts[i];
            if (lost <= -1) {
                continue;
            }
            
            for (int j = 0; j < reserves.length; j ++) {
                int reserve = reserves[j];
                if (reserve <= -1) {
                    continue;
                }
                
                if (lost + 1 == reserve) {
                    losts[i] = -1;
                    reserves[j] = -1;
                    break;
                 }
            }
        }
        
        int count = 0;
        for (int lost : losts) {
            if (lost > -1) {
                count += 1;
            }
        }

        return n - count;
    }
}