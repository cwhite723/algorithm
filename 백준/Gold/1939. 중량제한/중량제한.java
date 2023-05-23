import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, firstFactory, secondFactory;
    private static ArrayList<ArrayList<Node>> graph;
    private static long low, high, answer;

    private static class Node {
        int vertex;
        long weight;

        public Node(int vertex, long weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        findMaxWeight();
        output();
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void findMaxWeight() {
        while (low <= high) {
            long mid = (low + high) / 2;
            if (isPossible(mid)) {
                low = mid + 1;
                answer = mid;
            } else {
                high = mid - 1;
            }
        }
    }

    private static boolean isPossible(long mid) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];

        queue.offer(new Node(firstFactory, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 만약 현재 노드의 정점이 도착점이라면 가능한 경로기 때문에 true를 return한다.
            if (cur.vertex == secondFactory) return true;

            for (Node next : graph.get(cur.vertex)) {
                // 지나가야 할 다리의 중량이 현재 확인 중인 무게보다 크고 방문한 적이 없다면 지나갈 수 있다고 판단한다.
                // 따라서 큐에 다음 노드를 담고 방문 체크를 해준다.
                if (mid <= next.weight && !isVisited[next.vertex]) {
                    isVisited[next.vertex] = true;
                    queue.offer(next);
                }
            }
        }

        return false;
    }

    private static void input() throws IOException {
        low = Long.MAX_VALUE;
        high = Long.MIN_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 섬의 개수
        m = Integer.parseInt(st.nextToken()); // 다리 정보 수

        graph = new ArrayList<>(); // 섬 사이에 연결된 다리 정보

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            graph.get(first).add(new Node(second, weight));
            graph.get(second).add(new Node(first, weight));

            low = Math.min(weight, low);
            high = Math.max(weight, high);
        }

        st = new StringTokenizer(br.readLine());
        firstFactory = Integer.parseInt(st.nextToken()); // 공장이 위치한 섬 번호 1
        secondFactory = Integer.parseInt(st.nextToken()); // 공장이 위치한 섬 번호 2
    }
}
