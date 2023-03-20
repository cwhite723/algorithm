import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int value = 1;
        int index = 0;
        while(index<N) {
            if(stack.isEmpty()||stack.peek()<array[index]) {
                stack.push(value++);
                sb.append("+\n");
            }
            else if(stack.peek()>array[index]) {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
            if(stack.peek()==array[index]) {
                stack.pop();
                index++;
                sb.append("-\n");
            }
        }

        System.out.println(sb.toString());
    }
}
