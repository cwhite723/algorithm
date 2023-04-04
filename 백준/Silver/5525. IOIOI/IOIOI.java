import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String ADD_WORD = "OI";
    public static void main(String[] args) throws IOException {
        int findSize = Integer.parseInt(br.readLine());
        int wordSize = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int result = 0;

        StringBuilder findWord = new StringBuilder();
        findWord.append("IOI");

        for (int i=1; i<findSize; i++) {
            findWord.append(ADD_WORD);
        }

        int endIndex = findWord.length();

        for (int i=0; i<word.length()-findWord.length()+1; i++) {
            if(word.charAt(i)=='I') {
                if(word.substring(i, i+findWord.length()).equals(findWord.toString())) result++;
            }
        }

        System.out.println(result);

    }
}