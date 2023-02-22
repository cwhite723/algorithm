import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input1 = st.nextToken();
        String input2 = st.nextToken();

        StringBuilder sb = new StringBuilder(input1);
        input1 = sb.reverse().toString();
        sb = new StringBuilder(input2);
        input2 = sb.reverse().toString();

        int A = Integer.parseInt(input1);
        int B = Integer.parseInt(input2);

        System.out.println(Math.max(A,B));


    }
}