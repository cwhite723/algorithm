import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");
            
            while (!stack.isEmpty() && !queue.isEmpty() && stack.peek().equals(queue.peek())) {
                stack.pop();
                queue.poll();
                sb.append("-\n");
            }
        }
        
        if (!stack.isEmpty() || !queue.isEmpty()) {
            sb = new StringBuilder();
            sb.append("NO");
        }
        
        System.out.println(sb.toString().trim());
	}
}