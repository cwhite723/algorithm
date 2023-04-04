import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        int[][] network = new int[computers+1][computers+1];
        for(int i=0; i<pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            network[row][column] = 1;
            network[column][row] = 1;
        }

        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[computers+1];

        qu.add(1);
        visited[1] = true;

        while(!qu.isEmpty()) {
            int start = qu.poll();
            for(int i=1; i<=computers; i++) {
                if(network[start][i]==1&&!visited[i]) {
                    qu.add(i);
                    visited[i] = true;
                }
            }
        }

        int answer = 0;
        for(int i=2; i< visited.length; i++) {
            if(visited[i]) answer++;
        }

        System.out.println(answer);
    }
}