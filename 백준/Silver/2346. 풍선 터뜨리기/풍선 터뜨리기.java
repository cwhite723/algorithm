import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Node> list = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(new Node(i+1, Integer.parseInt(st.nextToken())));
        }

        while (list.size() > 1) {
            Node cur = list.pollFirst();
            sb.append(cur.index).append(" ");
            if (cur.value > 0) {
                for (int i = 0; i < cur.value - 1; i++) {
                    list.addLast(list.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(cur.value); i++) {
                    list.addFirst(list.pollLast());
                }
            }
        }
        sb.append(list.poll().index);
        System.out.println(sb.toString());
    }
}