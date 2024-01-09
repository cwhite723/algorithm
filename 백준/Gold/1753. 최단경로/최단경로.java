import java.io.*;
import java.util.*;

public class Main {

    /*
    * 가중지가 있는 간선이 존재하는 그래프
    * i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
    * 경로가 존재하지 않는 경우 INF를 출력한다.
     */

    private static int vertex, edge;
    private static int startVertex;
    private static List<List<Node>> graph = new ArrayList<>();
    private static boolean[] isVisited;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= vertex; i++) {
            bw.write(distance[i] == Integer.MAX_VALUE ? "INF\n" : distance[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void solve() {
        dijkstra();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        distance[startVertex] = 0;
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if (isVisited[currentNode.index]) continue;
            isVisited[currentNode.index] = true;
            
            for (Node node : graph.get(currentNode.index)) {
                int index = node.index;
                int cost = node.cost;

                if (!isVisited[index] && distance[index] > cost + distance[currentNode.index]) {
                    distance[index] = cost + distance[currentNode.index];
                    pq.add(new Node(index, distance[index]));
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(br.readLine());

        isVisited = new boolean[vertex + 1];
        distance = new int[vertex + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(info[0]).add(new Node(info[1], info[2]));
        }
    }
}

class Node {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}
