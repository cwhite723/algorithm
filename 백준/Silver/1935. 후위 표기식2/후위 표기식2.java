import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[26];
        Map<Character, Double> map = new HashMap<>();

        String pattern = "[A-Z]";
        String s = br.readLine();
        for (int i=0; i<s.length(); i++) {
            if(String.valueOf(s.charAt(i)).matches(pattern) && !check[s.charAt(i)-'A']) {
                map.put(s.charAt(i), Double.parseDouble(br.readLine()));
                check[s.charAt(i)-'A'] = true;
            }
        }

        Stack<Double> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(String.valueOf(c).matches(pattern)) {
                st.push(map.get(c));
            } else {
                double num1 = st.pop();
                double num2 = st.pop();
                if (c == '+') {
                    st.push(num2 + num1);
                } else if (c == '-') {
                    st.push(num2 - num1);
                } else if (c == '*') {
                    st.push(num2 * num1);
                } else {
                    st.push(num2 / num1);
                }
            }
        }

        System.out.printf("%.2f", st.pop());
    }
}