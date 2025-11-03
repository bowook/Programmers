class Solution {
    private int answer = 0;
    private boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    private void dfs(int fatigue, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i ++) {
            if (!visited[i] && dungeons[i][0] <= fatigue) {
                visited[i] = true; //방문함
                //더 들어가야함
                dfs(fatigue - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}