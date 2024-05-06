class Solution {
    public int solution(int[] number) {
        int answer = 0;

        // 배열의 길이가 3보다 작은 경우, 세 숫자의 조합이 불가능하므로 0을 반환
        if (number.length < 3) {
            return 0;
        }

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    // 세 숫자의 합이 0인 경우 answer를 1 증가
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
