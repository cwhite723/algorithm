import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        loop: for (int i=0; i<n; i++) {
            String s = br.readLine();
            Stack<Character> st = new Stack<>();
            for (int k=0; k<s.length(); k++) {
                Character c = s.charAt(k);
                if(c=='(') st.push(c);
                else if(c==')') {
                    if(st.isEmpty()) {
                        sb.append("NO\n");
                        continue loop;
                    } else {
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb.toString());
    }
}