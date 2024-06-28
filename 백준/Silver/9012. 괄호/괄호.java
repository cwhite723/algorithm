import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            String str = br.readLine();
            if (check(str)) sb.append("YES");
            else sb.append("NO");

            if (i != number - 1) sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty() || stack.peek() != '(') {
                return false;
            } else {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return false;
        else return true;
    }
}
