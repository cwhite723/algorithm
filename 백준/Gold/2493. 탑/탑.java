import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] laser = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            laser[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        sb.append("0 ");

        for(int i=1; i<n; i++) {
            while(!stack.isEmpty()) {
                int current = laser[stack.peek()];
                if(current<laser[i]) {
                    stack.pop();
                } else {
                    sb.append(stack.peek() + 1).append(" ");
                    break;
                }
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(i);
        }

        System.out.println(sb.toString());
    }
}