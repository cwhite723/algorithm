import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> qu = new LinkedList<>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.startsWith("push")) {
                String[] temp = s.split(" ");
                qu.addLast(Integer.valueOf(temp[1]));
                continue;
            } else if(s.equals("pop")) {
                if(qu.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(qu.pollFirst());
                }
            } else if(s.equals("size")) {
                sb.append(qu.size());
            } else if(s.equals("empty")) {
                if(qu.isEmpty()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            } else if(s.equals("front")) {
                if(qu.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(qu.getFirst());
                }
            } else {
                if(qu.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(qu.getLast());
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}