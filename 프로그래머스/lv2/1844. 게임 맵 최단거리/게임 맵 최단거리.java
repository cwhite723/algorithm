import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> qu = new LinkedList<>();
        int[][] visited = new int[n][m];
        
        int[] xPoint = {0, -1, 0, 1};
        int[] yPoint = {1, 0, -1, 0};

        qu.add(new int[]{0, 0});
        visited[0][0] = 1;
        while(!qu.isEmpty()) {
            int[] start = qu.poll();
            for(int i=0; i<4; i++) {
                int dx = start[0]+xPoint[i];
                int dy = start[1]+yPoint[i];
                if(dx>=0&&dy>=0&&dx<n&&dy<m) {
                    if(visited[dx][dy]==0&&maps[dx][dy]==1) {
                        visited[dx][dy] = visited[start[0]][start[1]]+1;
                        qu.add(new int[]{dx, dy});
                    }
                }
            }
        }
        return visited[n-1][m-1]==0 ? -1 : visited[n-1][m-1];
    }
}