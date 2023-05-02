import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cntClass = 0;
    static int[][] infoClass = {};
    static PriorityQueue<Lecture> lectures = new PriorityQueue<>((l1, l2) -> {
        return l1.start - l2.start;
    });
    static int answer = 1;
    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        convert();
        solve();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cntClass = Integer.parseInt(br.readLine());

        StringTokenizer st;
        infoClass = new int[cntClass][3];
        for (int i = 0; i < cntClass; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 3; k++) {
                infoClass[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void convert() {
        for (int i = 0; i < cntClass; i++) {
            lectures.add(new Lecture(infoClass[i][1], infoClass[i][2]));
        }
    }

    private static void solve() {
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        rooms.offer(lectures.poll().end);
        for (int i = 1; i < cntClass; i++) {
            Lecture cur = lectures.poll();
            if (!rooms.isEmpty()) {
                if (rooms.peek() <= cur.start) {
                    rooms.poll();
                } else {
                    answer++;
                }
            }
            rooms.offer(cur.end);
        }
    }

}
