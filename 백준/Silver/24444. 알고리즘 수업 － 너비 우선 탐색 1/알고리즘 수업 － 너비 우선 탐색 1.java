import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cntVertex, cntEdge, startVertex;
    static int[] sequence;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        bfs();
        output();
    }

    private static void output() {
        for (int i = 1; i <= cntVertex; i++) {
            System.out.println(sequence[i]);
        }
    }

    private static void bfs() {
        int depth = 1;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(startVertex);
        sequence[startVertex] = depth++;
        while (!qu.isEmpty()) {
            int start = qu.poll();
            List<Integer> cur = list.get(start);
            for (int i = 0; i < cur.size(); i++) {
                if (sequence[cur.get(i)] == 0) {
                    sequence[cur.get(i)] = depth++;
                    qu.add(cur.get(i));
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cntVertex = Integer.parseInt(st.nextToken());
        cntEdge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= cntVertex; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < cntEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }

        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        sequence = new int[cntVertex + 1];
    }
}
