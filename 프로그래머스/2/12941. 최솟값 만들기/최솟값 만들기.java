import java.util.*;

class Solution
{
    public int solution(int[] A, int[] B)
    {
        //한쪽은 오름차순 기준으로 정렬을 하고,
        //다른 한 쪽은 내림차순 기준으로 정렬을 하고,
        //각 인덱스 끼리 곱하면
        //최소값이 나옴
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        int idx = 0;
        for (int i = B.length - 1; i >=0; i --) {
            sum += A[idx] * B[i];
            idx += 1;
        }
        
        return sum;
    }
}