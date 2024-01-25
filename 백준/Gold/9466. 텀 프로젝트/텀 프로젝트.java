import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Map<Integer, Integer> maps;
    private static boolean[] isVisited;
    private static boolean[] isFinished;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < countCase; i++) {
            int countStudents = Integer.parseInt(br.readLine());
            maps = new HashMap<>();
            isVisited = new boolean[countStudents];
            isFinished = new boolean[countStudents];
            answer = 0;

            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < countStudents; k++) {
                maps.put(k, Integer.parseInt(st.nextToken()) - 1);
            }

            for (int k = 0; k < countStudents; k++) {
                find(k);
            }

            sb.append(countStudents - answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void find(int now) {
        if (isVisited[now]) return;

        isVisited[now] = true;
        int next = maps.get(now);

        if (!isVisited[next]) find(next);
        else {
            if (!isFinished[next]) {
                answer++;
                for (int i = next; i != now; i = maps.get(i)) {
                    answer++;
                }
            }
        }

        isFinished[now] = true;
    }
}
