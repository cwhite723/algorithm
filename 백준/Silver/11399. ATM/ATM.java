import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countPerson = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (st.hasMoreTokens()) {
            int time = Integer.parseInt(st.nextToken());
            pq.offer(time);
        }

        int total = 0;
        while (!pq.isEmpty()) {
            int time = pq.poll();
            total += time * countPerson--;
        }

        System.out.println(total);
    }
}
