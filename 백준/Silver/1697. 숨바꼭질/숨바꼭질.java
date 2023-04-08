import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        qu.add(n);
        visited[n] = true;

        while(n<k && !visited[k]) {
            int current = qu.poll();
            int[] next = {current*2, current+1, current-1};
            for(int i=0; i<3; i++) {
                if(next[i]>=0 && next[i]<visited.length && !visited[next[i]]) {
                    qu.add(next[i]);
                    visited[next[i]] = true;
                    dist[next[i]] = dist[current] + 1;
                }
            }
        }

        if(n>k) System.out.println(n-k);
        else System.out.println(dist[k]);
    }
}