import java.util.*;
class Solution {
    int[][] newRectangle;
    int characterX;
    int characterY;
    int itemX;
    int itemY;
    int[][] dis;
    boolean[][] visited;
    
    int bfs() {
        Queue<int[]> qu = new LinkedList<>();
        int[] xPoint = {0, -1, 0, 1};
        int[] yPoint = {1, 0, -1, 0};
        qu.add(new int[]{characterX, characterY});
        dis[characterX][characterY] = 1;
        visited[characterX][characterY] = true;
        while(!qu.isEmpty()) {
            int[] start = qu.poll();
            if(start[0]==itemX&&start[1]==itemY) break;
            for(int i=0; i<4; i++) {
                int newX = start[0]+xPoint[i];
                int newY = start[1]+yPoint[i];
                if(newX>=0&&newY>=0&&newX<=102&&newY<=102) {
                    if(!visited[newX][newY]&&newRectangle[newX][newY]==1) {
                        qu.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        dis[newX][newY] = dis[start[0]][start[1]] + 1;
                    }
                }
            }
        }
        return dis[itemX][itemY]/2;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.characterX = characterX*2;
        this.characterY = characterY*2;
        this.itemX = itemX*2;
        this.itemY = itemY*2;
        
        newRectangle = new int[102][102];
        dis = new int[102][102];
        visited = new boolean[102][102];

        //테두리를 포함한 모든 좌표값 1 넣기
        for(int[] arr : rectangle) {
            int x1 = arr[0]*2;
            int y1 = arr[1]*2;
            int x2 = arr[2]*2;
            int y2 = arr[3]*2;
            for(int k=x1; k<=x2; k++) {
                for(int i=y1; i<=y2; i++) {
                    newRectangle[k][i] = 1;
                }
            }
        }

        //테두리를 제외한 내부 좌표값 2 넣기
        for(int[] arr : rectangle) {
            int x1 = arr[0]*2;
            int y1 = arr[1]*2;
            int x2 = arr[2]*2;
            int y2 = arr[3]*2;
            for(int k=x1+1; k<x2; k++) {
                for(int i=y1+1; i<y2; i++) {
                    newRectangle[k][i] = 2;
                }
            }
        }

        return bfs();
    }
}