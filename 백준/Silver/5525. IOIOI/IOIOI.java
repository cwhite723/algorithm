import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[] word;
    public static boolean find(int index, int wordLen) {
        for(int k=index+1; k<index+wordLen; k++) {
            if(word[k]==word[k-1]) return false;
        }
        return true;
    }
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int findSize = Integer.parseInt(br.readLine());
        int wordSize = Integer.parseInt(br.readLine());
        word = br.readLine().toCharArray();

        int result = 0;
        int wordLen = 3 + (2 * (findSize-1));

        for (int i=0; i<wordSize-wordLen+1; i++) {
            if(word[i]=='I'&&find(i,wordLen)) {
                result++;
            }
        }

        System.out.println(result);

    }
}