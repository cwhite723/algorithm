import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] visit;
    static void seq(int count, String[] str, int k) {
        if(count==m) {
            for(int i=0; i<m; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                str[k] = String.valueOf(i);
                seq(count+1, Arrays.copyOfRange(str, 0, str.length+1), k+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];

        seq(0, new String[1],0);
    }
}