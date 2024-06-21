import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int queueSize = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int move = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= queueSize; i++) {
            queue.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(st.nextToken());
            int index = queue.indexOf(number);
            int middleIndex;

            if (queue.size() % 2 == 0) middleIndex = queue.size() / 2 - 1;
            else middleIndex = queue.size() / 2;

            if (index <= middleIndex) {
                for (int k = 0; k < index; k++) {
                    queue.offerLast(queue.pollFirst());
                    move++;
                }
            } else {
                for (int k = 0; k < queue.size() - index; k++) {
                    queue.offerFirst(queue.pollLast());
                    move++;
                }
            }
            queue.pollFirst();
        }

        System.out.println(move);
    }
}
