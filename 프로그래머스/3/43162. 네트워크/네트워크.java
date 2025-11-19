class Solution {

    private boolean[][] visited;
    private int maxRowAndCol;
    private int answer = 0;
    
    public int solution(int n, int[][] computers) {
        maxRowAndCol = n;
        visited = new boolean[n][n];
        
        for (int 기준컴퓨터 = 0; 기준컴퓨터 < n; 기준컴퓨터 ++) {
            for (int 찾고있는컴퓨터 = 0; 찾고있는컴퓨터 < n; 찾고있는컴퓨터 ++) {
                if (computers[기준컴퓨터][찾고있는컴퓨터] == 1 && !visited[기준컴퓨터][찾고있는컴퓨터]) {
                    dfs(기준컴퓨터, 찾고있는컴퓨터, computers);
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(int standardComputer, int connectedComputer, int[][] computers) {
        for (int i = 0; i < maxRowAndCol; i ++) {
            if (i == standardComputer || i == connectedComputer) {
                visited[connectedComputer][i] = true;
                continue;
            }
            if (!visited[connectedComputer][i] && computers[connectedComputer][i] == 1) {
                visited[connectedComputer][i] = true;
                dfs(connectedComputer, i, computers);
            }
        }
    }
}