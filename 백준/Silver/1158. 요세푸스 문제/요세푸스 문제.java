import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }

        while(!qu.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                qu.add(qu.poll());
            }
            list.add(qu.poll());
        }

        sb.append("<");
        for (int i = 0; i < list.size()-1; i++) {
            sb.append(list.get(i)).append(", ");
        }
        sb.append(list.get(list.size()-1)).append(">");

        System.out.println(sb.toString());
    }
}