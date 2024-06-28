import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static int MAX_LENGTH = 20;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] count = new int[MAX_LENGTH];

        for (int i = 0; i < number; i++) {
            int name = Integer.parseInt(br.readLine());
            int index = 0;
            while (name > 0) {
                count[index++] += name % 2;
                name /= 2;
            }
        }

        long sum = 0;
        for (int i = MAX_LENGTH - 1; i >= 0; i--) {
            sum += (long)count[i] * (number - count[i]);
            if (i != 0) sum <<= 1;
        }
        System.out.println(sum);
    }
}
