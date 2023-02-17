import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Max = 0;
        int price = 0;
        if(A==B) {
            if(A==C)
                price = 10000+(A*1000);
            else
                price = 1000+(A*100);
        }
        else if(B==C)
            price = 1000+(B*100);
        else if(A==C)
            price = 1000+(A*100);
        else {
            Max = Math.max(Math.max(A,B),C);
            price = 100*Max;
        }
        System.out.println(price);
    }
}