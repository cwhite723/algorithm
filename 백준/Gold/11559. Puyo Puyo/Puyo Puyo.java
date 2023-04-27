import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int ROW = 12;
    static final int COLUMN = 6;
    static boolean isMore;
    static String[][] gameBoard;
    static boolean[][] isvisited;
    static class Bbuyo {
        int x;
        int y;
        String color;

        public Bbuyo(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gameBoard = new String[ROW][COLUMN];
        for (int i = 0; i < ROW; i++) {
            String str = br.readLine();
            gameBoard[i] = str.split("");
        }

        int combo = 0;
        while (true) {
            isMore = false;

            bfs();
            onFloor();

            if (!isMore) break;
            combo++;
        }

        System.out.println(combo);
    }

    static void bfs() {
        Queue<Bbuyo> qu = new LinkedList<>();
        isvisited = new boolean[ROW][COLUMN];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = ROW - 1; i >= 0; i--) {
            for (int k = 0; k < COLUMN; k++) {
                if (!gameBoard[i][k].equals(".") && !isvisited[i][k]) {
                    List<int[]> list = new ArrayList<>();
                    qu.add(new Bbuyo(i, k, gameBoard[i][k]));
                    list.add(new int[]{i, k});
                    isvisited[i][k] = true;

                    while (!qu.isEmpty()) {
                        Bbuyo current = qu.poll();
                        int x = current.x;
                        int y = current.y;
                        String co = current.color;

                        for (int dir = 0; dir < 4; dir++) {
                            int nextX = x + dx[dir];
                            int nextY = y + dy[dir];
                            if (nextX < 0 || nextX >= ROW || nextY < 0 || nextY >= COLUMN || isvisited[nextX][nextY]) continue;

                            if (gameBoard[nextX][nextY].equals(co)) {
                                qu.add(new Bbuyo(nextX, nextY, gameBoard[nextX][nextY]));
                                list.add(new int[]{nextX, nextY});
                                isvisited[nextX][nextY] = true;
                            }
                        }
                    }

                    if (list.size() >= 4) {
                        for (int j = 0; j < list.size(); j++) {
                            gameBoard[list.get(j)[0]][list.get(j)[1]] = ".";
                            isMore = true;
                        }
                    }
                }
            }
        }
    }

    static void onFloor() {
        for (int i = 0; i < COLUMN; i++) {
            down(i);
        }
    }
    static void down(int j) {
        Queue<String> qu = new LinkedList<>();

        for (int i = ROW - 1; i >= 0; i--) {
            if (!gameBoard[i][j].equals(".")) {
                qu.add(gameBoard[i][j]);
                gameBoard[i][j] = ".";
            }
        }

        int index = ROW - 1;
        while (!qu.isEmpty()) {
            gameBoard[index--][j] = qu.poll();
        }
    }
}