import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        ArrayList<String> array = new ArrayList<>();

        for(int i=0; i<testCase; i++) {
            array.add(br.readLine());
            bw.write(score(array.get(i))+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static int score(String text) {
        int score = 0;
        int total = 0;
        String[] arr = text.split("");
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("O")) {
                score += 1;
                total += score;
            }
            else {
                score = 0;
                total += score;
            }
        }
        return total;
    }
}