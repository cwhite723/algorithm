import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Character[][] array = new Character[5][15];
        int columnMax = 0;

        for(int i=0; i<5; i++) {
            String A = br.readLine();
            for(int k=0; k<A.length(); k++) {
                array[i][k] = A.charAt(k);
            }
        }

        for(int i=0; i<15; i++) {
            for(int k=0; k<5; k++) {
                if(array[k][i]!=null) System.out.print(array[k][i]);
                else continue;
            }
        }

    }
}