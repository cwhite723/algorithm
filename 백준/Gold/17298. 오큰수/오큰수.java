import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] answer = new int[n];
        for(int i=1; i<n; i++) {
            while(!stack.isEmpty() && arr[i]>arr[stack.peek()]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        for(int i : answer) {
            sb.append(i+" ");
        }

        System.out.println(sb.toString().trim());
    }
}