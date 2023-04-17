import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int row, column, answer;
    static ArrayList<Cctv> cctvs;

    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    static int[][][] dir = {{},
            {{RIGHT}, {DOWN}, {LEFT}, {UP}},
            {{LEFT, RIGHT}, {UP, DOWN},{LEFT, RIGHT}, {UP, DOWN}},
            {{UP, RIGHT}, {RIGHT, DOWN}, {DOWN, LEFT}, {LEFT, UP}},
            {{UP, LEFT, RIGHT}, {UP, RIGHT, DOWN}, {RIGHT, DOWN, LEFT}, {DOWN, LEFT, UP}}};


    static class Cctv {
        int r;
        int c;
        int cctvNum;

        public Cctv(int r, int c, int cctvNum) {
            this.r = r;
            this.c = c;
            this.cctvNum = cctvNum;
        }
    }
    static void dfs(int index, int[][] arr) {
        if(index == cctvs.size()) {
            answer = Math.min(answer, zeroCount(arr));
            return;
        }

        Cctv cctv = cctvs.get(index);
        int r = cctv.r;
        int c = cctv.c;
        int[][] newArr = new int[row][column];
        for (int i=0; i<4; i++) {
            int[] next = dir[cctv.cctvNum][i];
            for(int k=0; k<row; k++) {
                newArr[k] = arr[k].clone();
            }
            for(int k=0; k<next.length; k++) {
                if(next[k] == LEFT) left(r, c, newArr);
                else if(next[k] == DOWN) down(r, c, newArr);
                else if(next[k] == RIGHT) right(r, c, newArr);
                else up(r, c, newArr);
            }
            dfs(index + 1, newArr);
        }

    }

    static int zeroCount(int[][] newArr) {
        int sum = 0;
        for(int i=0; i<row; i++) {
            for(int k=0; k<column; k++) {
                if(newArr[i][k] == 0) sum++;
            }
        }

        return sum;
    }

    static void right(int r, int c, int[][] newArr) {
        for(int i=c+1; i<column; i++) {
            if(newArr[r][i]==6) return;
            if(newArr[r][i]==0) newArr[r][i] = -1;
        }
    }

    static void left(int r, int c, int[][] newArr) {
        for(int i=c-1; i>=0; i--) {
            if(newArr[r][i]==6) return;
            if(newArr[r][i]==0) newArr[r][i] = -1;
        }
    }

    static void up(int r, int c, int[][] newArr) {
        for(int i=r-1; i>=0; i--) {
            if(newArr[i][c]==6) return;
            if(newArr[i][c]==0) newArr[i][c] = -1;
        }
    }

    static void down(int r, int c, int[][] newArr) {
        for(int i=r+1; i<row; i++) {
            if(newArr[i][c]==6) return;
            if(newArr[i][c]==0) newArr[i][c] = -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][column];
        cctvs = new ArrayList<>();
        answer = 70;

        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<column; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k]>0 && arr[i][k]<6) {
                    cctvs.add(new Cctv(i, k, arr[i][k]));
                }
            }
        }

        ArrayList<Cctv> newCctvs = new ArrayList<>();
        for(Cctv c : cctvs) {
            if(c.cctvNum == 5) {
                right(c.r, c.c, arr);
                down(c.r, c.c, arr);
                left(c.r, c.c, arr);
                up(c.r, c.c, arr);
            } else {
                newCctvs.add(c);
            }
        }
        cctvs = newCctvs;

        dfs(0, arr);
        System.out.println(answer);
    }
}