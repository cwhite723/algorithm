import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] cost;
    private static boolean[] visited;
    private static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            Traversal(i, i, 0, 0);
            visited[i] = false;
        }
    }

    private static void output() {
        System.out.println(minCost);
    }

    private static void Traversal(int start, int now, int depth, int currentCost) {
        if (depth == n - 1) {
            if (cost[now][start] == 0) return;
            
            currentCost += cost[now][start];
            minCost = Math.min(minCost, currentCost);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && cost[now][i] > 0) {
                visited[i] = true;

                Traversal(start, i, depth + 1, currentCost + cost[now][i]);

                visited[i] = false;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cost = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                cost[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
