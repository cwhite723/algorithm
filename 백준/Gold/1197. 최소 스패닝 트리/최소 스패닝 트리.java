import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int vertex, edge;
    private static int[] parent;
    private static PriorityQueue<Edge> edges;
    private static int answer = 0;

    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        parent = new int[vertex];
        edges = new PriorityQueue<>();

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            edges.offer(new Edge(from, to, cost));
        }

        for (int i = 0; i < vertex; i++) {
            parent[i] = i;
        }
    }

    private static void solve() {
        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            if (find(e.from) != find(e.to)) {
                answer += e.cost;
                union(e.from, e.to);
            }
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) parent[y] = x;
        else parent[x] = y;
    }

    private static int find(int x) {
        return parent[x] == x ? x : find(parent[x]);
    }

    private static void output() {
        System.out.println(answer);
    }
}