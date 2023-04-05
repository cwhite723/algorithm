import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    public int index;
    public int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for(int i=0; i<n; i++) {
            int current = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast().value > current) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, current));

            if(deque.getFirst().index <= i-l) {
                deque.removeFirst();
            }
            sb.append(deque.getFirst().value).append(" ");
        }

        System.out.println(sb.toString());
    }
}