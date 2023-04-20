import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        s = s.replace("()", ".");
        Stack<Character> st = new Stack<>();

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '.') answer += st.size();
            else if (c == '(') st.push(c);
            else {
                st.pop();
                answer++;
            }
        }
        System.out.println(answer);
    }
}