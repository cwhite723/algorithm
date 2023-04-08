import java.util.*;
class Solution {
    int[][] intMaps;
    int[][] dist;
    int row;
    int column;
    int time;
    
    public int bfs(int startX, int startY, int endX, int endY) {
        this.dist = new int[row][column];
        this.time = 0;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{startX, startY});
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(!qu.isEmpty()) {
            int[] current = qu.poll();
            for(int i=0; i<4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if(nextX>=0 && nextY>=0 && nextX<row && nextY<column) {
                    if(intMaps[nextX][nextY]==1&&dist[nextX][nextY]==0) {
                        qu.add(new int[]{nextX, nextY});
                        dist[nextX][nextY] = dist[current[0]][current[1]] + 1;
                    }
                }
            }
            if(dist[endX][endY]!=0) {
                break;
            }
        }

        if(dist[endX][endY]==0) {
            return -1;
        } else {
            time = dist[endX][endY];
        }
        
        return time;
    }
    
    public int solution(String[] maps) {
        this.row = maps.length;
        this.column = maps[0].length();
        this.time = 0;

        this.intMaps = new int[row][column];
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];

        for(int i=0; i<row; i++) {
            for(int k=0; k<column; k++) {
                char c = maps[i].charAt(k);
                if(c=='S') {
                    intMaps[i][k] = 1;
                    start[0] = i;
                    start[1] = k;
                } else if(c=='E') {
                    intMaps[i][k] = 1;
                    end[0] = i;
                    end[1] = k;
                } else if(c=='L') {
                    intMaps[i][k] = 1;
                    lever[0] = i;
                    lever[1] = k;
                }else if(c=='O') {
                    intMaps[i][k] = 1;
                } else {
                    intMaps[i][k] = 0;
                }
            }
        }

        int a = bfs(start[0], start[1], lever[0], lever[1]);
        int b = bfs(lever[0], lever[1], end[0], end[1]);
        
        if(a==-1||b==-1) return -1;
        else return a+b;
    }
}