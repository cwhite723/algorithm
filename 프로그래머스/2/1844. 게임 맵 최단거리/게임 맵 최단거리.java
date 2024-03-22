import java.util.*;

class Solution {
    int[][] maps;
    int weight, height;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.weight = maps.length;
        this.height = maps[0].length;
        
        return bfs();
    }
    
    private int bfs() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < weight && ny < height) {
                    if (maps[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        maps[nx][ny] = maps[x][y] + 1;
                    }
                    
                    if (nx == weight - 1 && ny == height - 1) return maps[nx][ny];
                }
            }
        }
        
        return -1;
    }
}