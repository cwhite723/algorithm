import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.equals("pop")) {
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }
            else if(s.equals("size")) {
                sb.append(stack.size()).append("\n");
            }
            else if(s.equals("empty")) {
                if(stack.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(s.equals("top")) {
                if(stack.isEmpty()) sb.append("-1").append("\n");
                else sb.append(stack.peek()).append("\n");
            }
            else {
                StringTokenizer st = new StringTokenizer(s);
                st.nextToken();
                stack.push(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(sb.toString());
    }
}