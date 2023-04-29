import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long k = 0;
    static long len = 0;
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(recursion(k));
    }

    static long findLen(long x) {
        len = 1;
        while (len < x) {
            len *= 2;
        }
        return len / 2;
    }

    private static int recursion(long x) {
        if (x == 1) return 0;
        len = findLen(x);
        return 1 - recursion(x - len);
    }
}
