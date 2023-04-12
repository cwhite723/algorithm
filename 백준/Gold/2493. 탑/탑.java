import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] laser = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            laser[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        answer[0] = 0;
        stack.push(0);

        for(int i=1; i<n; i++) {
            while(!stack.isEmpty()) {
                int current = laser[stack.peek()];
                if(current<laser[i]) {
                    stack.pop();
                } else {
                    answer[i] = stack.peek() + 1;
                    break;
                }
            }
            if(stack.isEmpty()) {
                answer[i] = 0;
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            System.out.print(answer[i]+" ");
        }
    }
}