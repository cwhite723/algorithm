import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] array = new int[100][100];

        int number = Integer.parseInt(br.readLine());
        for(int i=0; i<number; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            for(int k=A-1;k<A+9; k++) {
                for(int h=B-1; h<B+9; h++) {
                    array[k][h] = 1;
                }
            }
        }

        int result = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(array[i][j]==1) result++;
            }
        }
        System.out.println(result);

    }
}