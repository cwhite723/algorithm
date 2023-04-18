import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int row, column, stickerCnt, answer;
    static int[][] notebook;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        stickerCnt = Integer.parseInt(st.nextToken());
        answer = 0;
        notebook = new int[row][column];

        for(int i=0; i<stickerCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] currentSticker = new int[r][c];
            for(int k=0; k<r; k++) {
                st = new StringTokenizer(br.readLine());
                for(int t=0; t<c; t++) {
                    currentSticker[k][t] = Integer.parseInt(st.nextToken());
                }
            }
            isPossible(currentSticker);
        }
        System.out.println(answer);
    }

    static void isPossible(int[][] currentSticker) {
        int r = currentSticker.length;
        int c = currentSticker[0].length;

        for(int d=0; d<4; d++) {
            if (d!=0) {
                currentSticker = rotate(currentSticker);
            }
            r = currentSticker.length;
            c = currentSticker[0].length;
            for (int i=0; i<row; i++) {
                for (int k=0; k<column; k++) {
                    if (i+r>row || k+c>column) break;
                    if (attach(i, k, r, c, currentSticker)) {
                        return;
                    }
                }
            }
        }
    }

    static int[][] rotate(int[][] currentSticker) {
        int r = currentSticker.length;
        int c = currentSticker[0].length;
        int[][] newSticker = new int[c][r];

        for (int i=0; i<c; i++) {
            for (int k=0; k<r; k++) {
                newSticker[i][k] = currentSticker[r-k-1][i];
            }
        }

        return newSticker;
    }

    static boolean attach(int x, int y, int r, int c, int[][] sticker) {
        for (int i=x; i<x+r; i++) {
            for (int k=y; k<y+c; k++) {
                if (notebook[i][k] == 1 && sticker[i-x][k-y] == 1)
                    return false;
            }
        }
        for (int i=x; i<x+r; i++) {
            for (int k=y; k<y+c; k++) {
                if (sticker[i-x][k-y] == 1) {
                    notebook[i][k] = 1;
                    answer++;
                }
            }
        }
        return true;
    }
}