import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int countStairs;
    private static int[] score;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void output() {
        System.out.println(dp[countStairs - 1]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        countStairs = Integer.parseInt(br.readLine());
        score = new int[countStairs];
        dp = new int[countStairs];

        for (int i = 0; i < countStairs; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solve() {
        dp[0] = score[0];
        if (countStairs > 1) dp[1] = score[0] + score[1];
        if (countStairs > 2) dp[2] = Math.max(score[0], score[1]) + score[2];

        for (int i = 3; i < countStairs; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }
    }
}
