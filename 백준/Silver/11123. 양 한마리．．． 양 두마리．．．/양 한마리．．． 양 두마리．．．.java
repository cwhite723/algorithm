import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static String[][] sheep;
    private static int row;
    private static int col;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            sheep = new String[row][col];
            for (int k = 0; k < row; k++) {
                sheep[k] = br.readLine().split("");
            }
            int cnt = solve();
            sb.append(cnt).append("\n");
        }
    }

    private static int solve() {
        int answer = 0;

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (sheep[i][k].equals("#")) {
                    answer++;
                    sheep[i][k] = ".";

                    dfs(i, k);
                }
            }
        }

        return answer;
    }

    private static void dfs(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) {
                continue;
            }

            if (sheep[nextX][nextY].equals("#")) {
                sheep[nextX][nextY] = ".";
                dfs(nextX, nextY);
            }
        }
    }
}
