import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] numArr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            numArr[i] = numArr[i-1] + Long.parseLong(st.nextToken());
        }
        long sum = 0;
        for(int i=1; i<=n; i++) {
            numArr[i] %= m;
            if(numArr[i]==0) sum++;
        }

        Arrays.sort(numArr);
        long start = numArr[1];
        long count = 1;
        for(int i=2; i<=n; i++) {
            if(numArr[i]==start) count++;
            else {
                if(count>=2) sum += (count*(count-1)/2);
                count = 1;
                start = numArr[i];
            }
        }
        if(count>=2) sum += (count*(count-1)/2);
        System.out.println(sum );
    }
}