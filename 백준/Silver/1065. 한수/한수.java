import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=1; i<=N; i++) {
            count += calculate(i);
        }

        System.out.println(count);
    }

    static int calculate(int X) {
        if(X<100) return 1;

        int hundreds, tens, units;
        hundreds = X/100;
        tens = X/10%10;
        units = X%10;

        if(hundreds-tens == tens-units) return 1;
        else return 0;
    }
}