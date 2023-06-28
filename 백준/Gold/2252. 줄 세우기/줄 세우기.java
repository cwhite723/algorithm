import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int countStudent;
    private static List<List<Integer>> graph;
    private static int[] degree;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        topologicalSort();
        output();
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= countStudent; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void topologicalSort() {
        int sequence = 1;
        result = new int[countStudent + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= countStudent; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                result[sequence++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i : graph.get(current)) {
                degree[i]--;
                if (degree[i] == 0) {
                    queue.offer(i);
                    result[sequence++] = i;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        countStudent = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        degree = new int[countStudent + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= countStudent; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph.get(first).add(second);
            degree[second]++;
        }
    }
}
