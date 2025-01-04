import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());
            if (current == 0) {
                stack.pop();
                continue;
            }
            stack.push(current);
        }
        
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        System.out.println(sum);
    }
}