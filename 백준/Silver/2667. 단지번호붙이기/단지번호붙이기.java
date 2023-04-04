import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static boolean[][] visited;
    static int[][] house;
    static int n;
    static int bfs(int[] start) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> qu = new LinkedList<>();
        qu.add(start);
        int count = 1;
        while(!qu.isEmpty()) {
            start = qu.poll();
            for(int i=0; i<4; i++) {
                int nextX = start[0] + dx[i];
                int nextY = start[1] + dy[i];

                if(nextX>=0&&nextY>=0&&nextX<n&&nextY<n) {
                    if(house[nextX][nextY]==1&&!visited[nextX][nextY]) {
                        qu.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        house = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int k=0; k<n; k++) {
                house[i][k] = s.charAt(k)-'0';
            }
        }

        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                if(house[i][k]==1&&!visited[i][k]) {
                    visited[i][k] = true;
                    count++;
                    arr.add(bfs(new int[]{i, k}));
                }
            }
        }
        System.out.println(count);
        arr.stream().sorted().forEach(System.out::println);
    }
}