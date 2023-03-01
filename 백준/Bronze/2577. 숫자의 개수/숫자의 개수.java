import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int result = A*B*C;

        int[] array = new int[10];
        while(result>0) {
            int N = result%10;
            array[N]++;
            result /= 10;
        }

        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}