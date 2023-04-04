import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];
        int[][] dist = new int[n][m];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int k=0; k<m; k++) {
                maze[i][k] = s.charAt(k)-'0';
            }
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{0, 0});
        dist[0][0] = 1;

        while(!qu.isEmpty()) {
            int[] start = qu.poll();
            int x = start[0];
            int y = start[1];
            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX<0||nextY<0||nextX>=n||nextY>=m) continue;
                if(maze[nextX][nextY]==1&&dist[nextX][nextY]==0) {
                    qu.add(new int[]{nextX, nextY});
                    dist[nextX][nextY] = dist[x][y] + 1;
                }
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}