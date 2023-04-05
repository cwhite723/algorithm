import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int[][] family = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            family[parent][child] = 1;
            family[child][parent] = 1;
        }

        boolean[] visited = new boolean[n+1];
        int[] depth = new int[n+1];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(person1);
        visited[person1] = true;
        int count = 0;
        while(!qu.isEmpty()) {
            int start = qu.poll();
            for(int i=1; i<=n; i++) {
                if(family[start][i]==1&&!visited[i]) {
                    qu.add(i);
                    visited[i] = true;
                    depth[i] = depth[start] + 1;
                }
            }
            if(visited[person2]) break;
        }
        if(!visited[person2]) System.out.println(-1);
        else System.out.println(depth[person2]);

    }
}