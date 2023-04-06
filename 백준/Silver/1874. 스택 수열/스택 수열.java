import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        int start = 1;
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            while(start<=num) {
                st.push(start++);
                sb.append("+\n");
            }
            if(!st.isEmpty()&&st.peek()==num) {
                st.pop();
                sb.append("-\n");
            }
        }
        if(!st.isEmpty()) System.out.println("NO");
        else System.out.println(sb.toString());
    }
}