import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] array1 = new int[N][M];
        int[][] array2 = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<M; k++) {
                array1[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<M; k++) {
                array2[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int k=0; k<M; k++) {
                System.out.print(array1[i][k]+array2[i][k]+" ");
            }
            System.out.println();
        }


    }
}