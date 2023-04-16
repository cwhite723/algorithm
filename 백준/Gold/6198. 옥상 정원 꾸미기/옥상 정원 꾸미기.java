import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        long answer = 0;

        for(int i=0; i<n; i++) {
            int current = Integer.parseInt(br.readLine());
            while(!st.isEmpty()) {
                if(st.peek()<=current) {
                    st.pop();
                } else {
                    break;
                }
            }
            st.push(current);
            answer += st.size()-1;
        }

        System.out.println(answer);
    }
}