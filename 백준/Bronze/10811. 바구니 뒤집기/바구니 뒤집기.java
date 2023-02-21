import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        for(int i=0; i<N; i++) {
            array[i] = i+1;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st.nextToken())-1;
            int change = Integer.parseInt(st.nextToken())-1;

            for(int k=origin; k<change; k++) {
                int temp = array[k];
                array[k] = array[change];
                array[change] = temp;
                change--;
                if(k>=change) break;
            }
        }

        for(int i=0; i<N; i++) {
            System.out.print(array[i]+" ");
        }



    }
}