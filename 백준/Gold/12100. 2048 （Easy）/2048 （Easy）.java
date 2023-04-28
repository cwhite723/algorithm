import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int boardSize;
    static int[][] gameBoard;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boardSize = Integer.parseInt(br.readLine());
        gameBoard = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < boardSize; k++) {
                gameBoard[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        startGame(0);
        System.out.println(answer);
    }

    private static void startGame(int count) {
        if (count == 5) {
            findMax();
            return;
        }

        int temp[][] = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            temp[i] = gameBoard[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0 : {
                    moveUp();
                    break;
                }
                case 1 : {
                    moveDown();
                    break;
                }
                case 2 : {
                    moveRight();
                    break;
                }
                case 3 : {
                    moveLeft();
                    break;
                }
            }
            startGame(count + 1);
            for (int k = 0; k < boardSize; k++) {
                gameBoard[k] = temp[k].clone();
            }
        }
    }

    private static void findMax() {
        for (int i = 0; i < boardSize; i++) {
            for (int k = 0; k < boardSize; k++) {
                answer = Math.max(answer, gameBoard[i][k]);
            }
        }
    }

    private static void moveUp() {
        for (int i = 0; i < boardSize; i++) {
            int index = 0;
            int block = 0;
            for (int k = 0; k < boardSize; k++) {
                if (gameBoard[k][i] != 0) {
                    if (block != gameBoard[k][i]) {
                        block = gameBoard[k][i];
                        gameBoard[k][i] = 0;
                        gameBoard[index][i] = block;
                    } else {
                        index--;
                        gameBoard[index][i] = block * 2;
                        block = 0;
                        gameBoard[k][i] = 0;
                    }
                    index++;
                }
            }
        }
    }

    private static void moveDown() {
        for (int i = 0; i < boardSize; i++) {
            int index = boardSize - 1;
            int block = 0;
            for (int k = boardSize - 1; k >= 0; k--) {
                if (gameBoard[k][i] != 0) {
                    if (block != gameBoard[k][i]) {
                        block = gameBoard[k][i];
                        gameBoard[k][i] = 0;
                        gameBoard[index][i] = block;
                    } else {
                        index++;
                        gameBoard[index][i] = block * 2;
                        block = 0;
                        gameBoard[k][i] = 0;
                    }
                    index--;
                }
            }
        }
    }

    private static void moveLeft() {
        for (int i = 0; i < boardSize; i++) {
            int index = 0;
            int block = 0;
            for (int k = 0; k < boardSize; k++) {
                if (gameBoard[i][k] != 0) {
                    if (block != gameBoard[i][k]) {
                        block = gameBoard[i][k];
                        gameBoard[i][k] = 0;
                        gameBoard[i][index] = block;
                    } else {
                        index--;
                        gameBoard[i][index] = block * 2;
                        block = 0;
                        gameBoard[i][k] = 0;
                    }
                    index++;
                }
            }
        }
    }

    private static void moveRight() {
        for (int i = 0; i < boardSize; i++) {
            int index = boardSize - 1;
            int block = 0;
            for (int k = boardSize - 1; k >= 0; k--) {
                if (gameBoard[i][k] != 0) {
                    if (block != gameBoard[i][k]) {
                        block = gameBoard[i][k];
                        gameBoard[i][k] = 0;
                        gameBoard[i][index] = block;
                    } else {
                        index++;
                        gameBoard[i][index] = block * 2;
                        block = 0;
                        gameBoard[i][k] = 0;
                    }
                    index--;
                }
            }
        }
    }
}