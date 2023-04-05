import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;
        while(endIndex<n) {
            if(sum<=n) {
                endIndex++;
                sum += endIndex;
            }
            else if(sum>n) {
                sum -= startIndex;
                startIndex++;
            }
            if(sum==n) count++;
        }
        System.out.println(count);
    }
}