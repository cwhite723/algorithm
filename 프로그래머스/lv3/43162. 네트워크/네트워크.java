import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            queue.add(i);
            if(!visited[i]) {
                while(!queue.isEmpty()) {
                    int start = queue.poll();
                    for(int k=0; k<n; k++) {
                        if(!visited[k]&&computers[start][k]==1) {
                            visited[k] = true;
                            queue.add(k);
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}