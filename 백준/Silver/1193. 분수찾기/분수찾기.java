import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int row = 1; 
        int plus = 1; 
        int n = 1; 

        int top, bottom;

        while(X>row) {
            row += ++plus;
            n++;
        }
        
        if(n%2==0) {
            bottom = row-X+1;
            top = n+1-bottom;
        }
        else {
            top = row-X+1;
            bottom = n+1-top;
        }

        System.out.println(top+"/"+bottom);
    }
}