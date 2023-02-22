import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = 1;
        for(int i=0, k=input.length()-1; i<(input.length()/2); i++,k-- ) {
            if(input.charAt(i)!=input.charAt(k)) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}