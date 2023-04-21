import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());
            if (current == 0) {
                if (qu.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(qu.poll()).append("\n");
                }
            } else {
                qu.add(current);
            }
        }

        System.out.println(sb.toString());

    }
}