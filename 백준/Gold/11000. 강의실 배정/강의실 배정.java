import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int answer = 1;
    static PriorityQueue<Lecture> lectures = new PriorityQueue<>((l1, l2) -> {
        return l1.startTime - l2.startTime;
    });
    static class Lecture {
        int startTime;
        int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        solve();
        output();
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void solve() {
        PriorityQueue<Integer> classroom = new PriorityQueue<>((c1, c2) -> {
            return c1 - c2;
        });
        while (!lectures.isEmpty()) {
            Lecture curLecture = lectures.poll();
            if (!classroom.isEmpty()) {
                if (classroom.peek() <= curLecture.startTime) {
                    classroom.poll();
                } else {
                    answer++;
                }
            }
            classroom.offer(curLecture.endTime);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.offer(new Lecture(start, end));
        }
    }
}
