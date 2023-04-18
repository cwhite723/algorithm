import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX_NUM = 1400;
    static int n, chickenCnt, answer;
    static int[][] city;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> house;
    static ArrayList<int[]> choice;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        chickenCnt = Integer.parseInt(st.nextToken());
        city = new int[n][n];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        choice = new ArrayList<>();
        answer = MAX_NUM;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                city[i][k] = Integer.parseInt(st.nextToken());
                if (city[i][k] == 2) {
                    chicken.add(new int[]{i, k});
                } else if (city[i][k] == 1) {
                    house.add(new int[]{i, k});
                }
            }
        }
        visit = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int start) {
        if (depth == chickenCnt) {
            int sum = 0;
            for (int[] h : house) {
                int min = MAX_NUM;
                for (int[] c : choice) {
                    int d = Math.abs(h[0]-c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(d, min);
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i=start; i<chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                choice.add(chicken.get(i));
                dfs(depth + 1, i + 1);
                choice.remove(choice.size()-1);
                visit[i] = false;
            }
        }
    }
}