import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int vertex, edge;
    private static int start, end;
    private static List<List<Node>> nodes = new ArrayList<>();
    private static int[] dist;
    private static int answer = 0;

    private static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        dist = new int[vertex];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < vertex; i++) {
            nodes.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            nodes.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.to]) continue;

            for (Node next : nodes.get(current.to)) {
                if (dist[next.to] > current.cost + next.cost) {
                    dist[next.to] = current.cost + next.cost;
                    pq.offer(new Node(next.to, current.cost + next.cost));
                }
            }
        }

        answer = dist[end];
    }

    private static void output() {
        System.out.println(answer);
    }
}
