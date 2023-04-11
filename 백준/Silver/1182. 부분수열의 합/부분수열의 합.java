import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static boolean[] visit;
    static int[] arr;
    static int count;
    
    static void seq(int sum, int start) {
        if(start==n) {
            if(s==sum) {
                count++;
            }
            return;
        }

        seq(sum, start+1);
        seq(sum+arr[start], start+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        visit = new boolean[n];

        seq(0, 0);
        System.out.println(s==0 ? count-1 : count);
    }
}