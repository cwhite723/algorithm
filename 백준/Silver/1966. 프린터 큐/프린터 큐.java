import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int index;
        int important;

        public Node(int index, int important) {
            this.index = index;
            this.important = important;
        }
    }
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int find = Integer.parseInt(st.nextToken());

            Queue<Node> qu = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                qu.add(new Node(k, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            while(!qu.isEmpty()) {
                int max = qu.stream().mapToInt(k -> k.important).max().getAsInt();
                if (qu.peek().important < max) {
                    qu.add(qu.poll());
                } else {
                    Node current = qu.poll();
                    count++;

                    if(current.index == find) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}