import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int v;
    static int[][] array;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for(int i=1; i<n+1; i++) {
            if(array[start][i]==1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        StringBuilder sb2 = new StringBuilder();
        Queue<Integer> qu = new LinkedList<>();
        visited = new boolean[n+1];
        qu.add(start);
        visited[start] = true;
        while(!qu.isEmpty()) {
            start = qu.poll();
            sb2.append(start).append(" ");
            for(int i=1; i<n+1; i++) {
                if(array[start][i]==1&&!visited[i]) {
                    visited[i] = true;
                    qu.add(i);
                }
            }
        }
        System.out.println(sb2.toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        array = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            array[row][column] = 1;
            array[column][row] = 1;
        }

        dfs(v);
        System.out.println(sb.toString());
        bfs(v);
    }
}