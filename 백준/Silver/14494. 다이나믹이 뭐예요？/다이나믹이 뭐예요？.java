import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int DEV = 1_000_000_007;
    static int endRow, endCol;
    static long[][] map;
    public static void main(String[] args) throws IOException {
        input();
        dp();
        output();
    }

    private static void output() {
        System.out.println(map[endRow][endCol]);
    }

    private static void dp() {
        for (int i = 2; i <= endRow; i++) {
            for (int k = 2; k <= endCol; k++) {
                map[i][k] = (map[i - 1][k] + map[i][k - 1] + map[i - 1][k - 1]) % DEV;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        endRow = Integer.parseInt(st.nextToken());
        endCol = Integer.parseInt(st.nextToken());
        
        map = new long[endRow + 1][endCol + 1];
        for (int i = 1; i <= endRow; i++) {
            map[i][1] = 1;
        }
        for (int i = 1; i <= endCol; i++) {
            map[1][i] = 1;
        }
    }
}
