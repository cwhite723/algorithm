import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[][] map;
    private static int len;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0, Integer.parseInt(map[0][0]));
        output();
    }

    private static void output() {
        System.out.print(max + " " + min);
    }

    private static void solve(int x, int y, int sum) {
        if (x == len - 1 && y == len - 1) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);

            return;
        }

        int[] dx = {1, 2, 0};
        int[] dy = {1, 0, 2};

        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= len || nextY >= len) continue;

            int temp;

            if (i == 0) {
                temp = calculate(sum, Integer.parseInt(map[nextX][nextY]), map[x + 1][y]);
                solve(nextX, nextY, temp);
                temp = calculate(sum, Integer.parseInt(map[nextX][nextY]), map[x][y + 1]);
                solve(nextX, nextY, temp);
            }else if (i == 1) {
                temp = calculate(sum, Integer.parseInt(map[nextX][nextY]), map[x + 1][y]);
                solve(nextX, nextY, temp);
            } else if (i == 2) {
                temp = calculate(sum, Integer.parseInt(map[nextX][nextY]), map[x][y + 1]);
                solve(nextX, nextY, temp);
            }
        }
    }

    private static int calculate(int sum, int operand, String oper1) {
        int result = 0;

        switch (oper1) {
            case "+":
                result = sum + operand;
                break;
            case "-":
                result = sum - operand;
                break;
            case "*":
                result = sum * operand;
        }

        return result;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());

        map = new String[len][len];
        for (int i = 0; i < len; i++) {
            map[i] = br.readLine().split(" ");
        }
    }
}
