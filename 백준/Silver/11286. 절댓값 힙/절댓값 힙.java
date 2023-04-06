import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> qu = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            } else {
                return first_abs - second_abs;
            }
        });

        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp!=0) qu.add(temp);
            else if(!qu.isEmpty()&&temp==0) sb.append(qu.poll()).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb.toString());
    }
}