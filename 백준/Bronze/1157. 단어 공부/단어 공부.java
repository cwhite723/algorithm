import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.toUpperCase();
        int[] al = new int[26];
        Arrays.fill(al,0);

        for(int i=0; i<input.length(); i++) {
            al[(int)input.charAt(i)-65]++;
        }

        int max=-1;
        int index=0;
        for(int k=0; k<al.length; k++) {
            if(al[k]==max) {
                index=-1;
            }
            if(al[k]>max) {
                max = al[k];
                index = k;
            }
        }

        if(index!=-1) System.out.println((char)(index+65));
        else System.out.println("?");
    }
}