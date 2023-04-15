import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, row, column, answer;

    static void seq(int size, int row, int column) {
        if(size == 1) {
            return;
        }

        int n = size/2;
        if(row<n && column<n) {
            seq(n, row, column);
        } else if(row<n && column>=n) {
            answer += n*n;
            seq(n, row, column-n);
        } else if(row>=n && column<n) {
            answer += n*n*2;
            seq(n, row-n, column);
        } else {
            answer += n*n*3;
            seq(n, row-n, column-n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        answer = 0;

        seq((int) Math.pow(2, n), row, column);
        System.out.println(answer);
    }
}