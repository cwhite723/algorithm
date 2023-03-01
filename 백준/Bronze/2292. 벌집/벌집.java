import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int plus = 6;
        int result = 2;
        while (true) {
            if(N==1) {
                result = 1;
                break;
            }
            start += plus;
            if(N>start) result ++;
            else break;
            plus += 6;
        }

        System.out.println(result);

    }
}