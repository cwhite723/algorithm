import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int max = Collections.max(arr);
        int min = Collections.min(arr);

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
        br.close();

    }
}