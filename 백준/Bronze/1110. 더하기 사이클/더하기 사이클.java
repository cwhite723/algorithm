import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int newN = N;
        int count = 0;
        br.close();

        while(true) {
            count++;
            int units = newN%10;
            int tens = newN/10;

            newN = units*10 + ((tens+units)%10);
            if(newN==N) break;
        }

        System.out.println(count);

    }
}