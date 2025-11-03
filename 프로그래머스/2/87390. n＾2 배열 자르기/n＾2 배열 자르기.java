class Solution {
    public int[] solution(int n, long left, long right) {
        //2차원 배열을 1차원으로 만들어야 하니까 n이 3이면 1차원은 n^2이니까 9개의 값이 들어가야함.
        //반복 다 때리면 시간초과라서 수학문제임
        //패턴 찾아야함
        int[] answer = new int[(int)(right - left + 1)];
        
        for (long i = left; i <= right; i ++) {
            long row = i / n;
            long col = i % n;
            answer[(int)(i - left)] = (int)Math.max(row,col) + 1;
        }
        
        return answer;
    }
}