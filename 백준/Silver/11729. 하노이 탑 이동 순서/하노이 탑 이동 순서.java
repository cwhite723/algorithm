import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int count;
    static StringBuilder sb = new StringBuilder();
    
    static void hanoi(int start, int end, int n) {
        count++;
        if(n==1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(start, 6-start-end, n-1);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(6-start-end, end, n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        count = 0;
        hanoi(1, 3, n);
        System.out.println(count);
        System.out.println(sb.toString());
    }
}