import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int size = 0;
    static int[][] chairs = {};
    static int answer;

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        StringTokenizer st;
        chairs = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < size; k++) {
                chairs[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void output() {
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        answer = solve(0, 0, size);
        output();
    }

    private static int solve(int X, int Y, int curSize) {

        if (curSize == 1) {
            return chairs[X][Y];
        }

        int nextSize = curSize / 2;
        int[] result = new int[4];
        result[0] = solve(X, Y, nextSize);
        result[1] = solve(X, Y + nextSize, nextSize);
        result[2] = solve(X + nextSize, Y, nextSize);
        result[3] = solve(X + nextSize, Y + nextSize, nextSize);
        Arrays.sort(result);
        return result[1];
    }
}
