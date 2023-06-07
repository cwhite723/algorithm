import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int totalMosquito;
    private static long maxMosquito = 0;
    private static long maxStartTime, maxEndTime;
    private static PriorityQueue<Mosquito> mosquito = new PriorityQueue<>((r1, r2) -> {
        if (r1.admissionTime > r2.admissionTime) return 1;
        else return -1;
    });
    private static PriorityQueue<Mosquito> room = new PriorityQueue<>((r1, r2) -> {
        if (r1.exitTime > r2.exitTime) return 1;
        else return -1;
    });

    private static class Mosquito {
        long admissionTime;
        long exitTime;

        public Mosquito(long admissionTime, long exitTime) {
            this.admissionTime = admissionTime;
            this.exitTime = exitTime;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void output() {
        System.out.println(maxMosquito);
        System.out.println(maxStartTime + " " + maxEndTime);
    }

    private static void solve() {
        while (!mosquito.isEmpty()) {
            Mosquito current = mosquito.poll();
            while (!room.isEmpty() && room.peek().exitTime <= current.admissionTime) {
                room.poll();
            }
            room.offer(current);

            if (maxMosquito < room.size()) {
                maxMosquito = room.size();
                maxStartTime = current.admissionTime;
                maxEndTime = room.peek().exitTime;
            }
            if (maxMosquito == room.size() && maxEndTime == current.admissionTime) {
                maxEndTime = room.peek().exitTime;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalMosquito = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalMosquito; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long admissionTime = Long.parseLong(st.nextToken());
            long exitTime = Long.parseLong(st.nextToken());
            mosquito.offer(new Mosquito(admissionTime, exitTime));
        }
    }
}
