import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static final int STACK_COUNT = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < STACK_COUNT; i++) {
            stacks[i] = new Stack<>();
            stacks[i].push(0);
        }

        boolean possible = true;
        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());
            boolean inserted = false;
            for (int i = 0; i < STACK_COUNT; i++) {
                if (current > stacks[i].peek()) {
                    stacks[i].push(current);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                possible = false;
                break;
            }
        }

        if (possible) System.out.println("YES");
        else System.out.println("NO");
    }
}
