import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long pow(long a, long b, long c) {
        if (b == 1)
            return a % c;
        long n = pow(a, b/2, c);
        if(b%2 == 0)
            return n * n % c;
        else
            return (n * n % c) * a % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long answer = pow(a, b, c);
        System.out.println(answer);
    }
}