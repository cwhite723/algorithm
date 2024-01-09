import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
    배추가 군데군데 심어져 있다.
    배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 된다.
    필요한 배추흰지렁이의 수를 구해야 한다.
     */

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] field;
    private static int row, column, countCabbage;
    private static Queue<int[]> queue;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        int countCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < countCase; i++) {
            input();
            solve();
        }

        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        countCabbage = Integer.parseInt(st.nextToken());
        field = new int[row][column];
        isVisited = new boolean[row][column];
        queue = new LinkedList<>();

        for (int i = 0; i < countCabbage; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            field[y][x] = 1;
        }
    }

    private static void solve() throws IOException {
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                if (!isVisited[i][k] && field[i][k] == 1) {
                    queue.offer(new int[]{i, k});
                    isVisited[i][k] = true;
                    count++;
                    bfs();
                }
            }
        }

        bw.write(count + "\n");
    }
    private static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (validateRange(nextX, nextY) && field[nextX][nextY] == 1 && !isVisited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }

    private static boolean validateRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}
