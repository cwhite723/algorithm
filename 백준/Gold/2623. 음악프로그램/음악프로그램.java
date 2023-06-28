import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int countSinger;
    private static List<List<Integer>> graph;
    private static int[] degree;
    private static int[] result;
    private static Queue<Integer> queue;
    private static boolean isImpossible = false;
    private static int sequence;

    public static void main(String[] args) throws IOException {
        input();
        topologicalSort();
        output();
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        if (!queue.isEmpty() || isImpossible || sequence != countSinger + 1) {
            System.out.println(0);
        } else {
            for (int i = 1; i < result.length; i++) {
                sb.append(result[i]).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static void topologicalSort() {
        sequence = 1;
        result = new int[countSinger + 1];
        queue = new LinkedList<>();

        for (int i = 1; i <= countSinger; i++) {
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

        countSinger = Integer.parseInt(st.nextToken());
        int countPd = Integer.parseInt(st.nextToken());

        degree = new int[countSinger + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= countSinger; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < countPd; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < count; k++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int k = 0; k < count; k++) {
                for (int j = k + 1; j < count; j++) {
                    int first = list.get(k);
                    int second = list.get(j);

                    if (graph.get(first).contains(second)) {
                        continue;
                    }
                    if (graph.get(second).contains(first)) {
                        isImpossible = true;
                        return;
                    }

                    graph.get(first).add(second);
                    degree[second]++;
                }
            }
        }


    }
}
