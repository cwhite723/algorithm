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

        int[][] numArr = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            numArr[i][1] = Integer.parseInt(st.nextToken());
            for(int k=2; k<=n; k++) {
                numArr[i][k] = numArr[i][k-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int k=startX; k<=endX; k++) {
                sum += numArr[k][endY]-numArr[k][startY-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}