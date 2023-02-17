import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0; i<9; i++) array.add(Integer.parseInt(br.readLine()));
        br.close();

        int max = Collections.max(array);
        int sequence = array.indexOf(max) + 1;

        bw.write(max + "\n" + sequence);
        bw.flush();
        bw.close();
    }
}