class Solution {
    int n;
    int[][] computers;
    int answer;
    boolean visited[];
    
    void dfs(int start) {
        visited[start] = true;
        for(int i=0; i< computers.length; i++) {
            if(!visited[i]&&computers[start][i]==1) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[computers.length];
        this.answer = 0;
        
        for(int i=0 ;i<computers.length; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}