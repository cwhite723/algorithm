import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static int M;
    static int V;
    static String result;
    static String BFS() {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N+1];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(V);
        visited[V] = true;
        while(!qu.isEmpty()) {
            int start = qu.poll();
            sb.append(start).append(" ");
            for(int i=1; i<=N; i++) {
                if(!visited[i]&&arr[start][i]==1) {
                    qu.add(i);
                    visited[i] = true;
                }
            }
        }
        return sb.toString();
    }

    static void DFS(boolean[] visited,  int start) {
        visited[start] = true;
        result += start + " ";

        for(int i=1; i<=N; i++) {
            if(arr[start][i]==1&&!visited[i]) {
                DFS(visited, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        result = "";

        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        boolean[] visited = new boolean[N+1];
        DFS(visited, V);
        String bfs = BFS();
        System.out.println(result);
        System.out.println(bfs);
    }
}

