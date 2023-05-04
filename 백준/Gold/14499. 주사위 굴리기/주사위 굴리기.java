import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int EAST = 1;
    static final int WEST = 2;
    static final int NORTH = 3;
    static final int SOUTH = 4;
    static int row = 0;
    static int col = 0;
    static int startDiceX = 0;
    static int startDiceY = 0;
    static int k = 0;
    static int[][] map;
    static int[] command;
    static StringBuilder sb = new StringBuilder();
    static class Dice {
        int top, front, bottom, back, left, right;

        public Dice(int top, int front, int bottom, int back, int left, int right) {
            this.top = top;
            this.front = front;
            this.bottom = bottom;
            this.back = back;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        move();
        output();
    }

    private static void output() {
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        startDiceX = Integer.parseInt(st.nextToken());
        startDiceY = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        command = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void move() {
        Dice dice = new Dice(0, 0, 0, 0, 0, 0);
        for (int i = 0; i < k; i++) {
            if (command[i] == EAST) moveEast(dice);
            else if (command[i] == WEST) moveWest(dice);
            else if (command[i] == NORTH) moveNorth(dice);
            else moveSouth(dice);
        }
    }

    private static void moveEast(Dice dice) {
        int newX = startDiceX;
        int newY = startDiceY + 1;

        if (newX < 0 || newY < 0 || newX >= row || newY >= col) return;

        int temp = dice.top;
        dice.top = dice.left;
        dice.left = dice.bottom;
        dice.bottom = dice.right;
        dice.right = temp;

        checkMapValue(dice, newX, newY);

        startDiceX = newX;
        startDiceY = newY;

        sb.append(dice.top).append("\n");
    }

    private static void moveWest(Dice dice) {
        int newX = startDiceX;
        int newY = startDiceY - 1;

        if (newX < 0 || newY < 0 || newX >= row || newY >= col) return;

        int temp = dice.top;
        dice.top = dice.right;
        dice.right = dice.bottom;
        dice.bottom = dice.left;
        dice.left = temp;

        checkMapValue(dice, newX, newY);

        startDiceX = newX;
        startDiceY = newY;

        sb.append(dice.top).append("\n");
    }

    private static void moveNorth(Dice dice) {
        int newX = startDiceX - 1;
        int newY = startDiceY;

        if (newX < 0 || newY < 0 || newX >= row || newY >= col) return;

        int temp = dice.back;
        dice.back = dice.top;
        dice.top = dice.front;
        dice.front = dice.bottom;
        dice.bottom = temp;

        checkMapValue(dice, newX, newY);

        startDiceX = newX;
        startDiceY = newY;

        sb.append(dice.top).append("\n");
    }

    private static void moveSouth(Dice dice) {
        int newX = startDiceX + 1;
        int newY = startDiceY;

        if (newX < 0 || newY < 0 || newX >= row || newY >= col) return;

        int temp = dice.back;
        dice.back = dice.bottom;
        dice.bottom = dice.front;
        dice.front = dice.top;
        dice.top = temp;

        checkMapValue(dice, newX, newY);

        startDiceX = newX;
        startDiceY = newY;

        sb.append(dice.top).append("\n");
    }

    private static void checkMapValue(Dice dice, int newX, int newY) {
        if (map[newX][newY] != 0) {
            dice.bottom = map[newX][newY];
            map[newX][newY] = 0;
        } else {
            map[newX][newY] = dice.bottom;
        }
    }
}