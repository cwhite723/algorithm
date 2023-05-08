import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int cntScv;
    static int[] hp = new int[3]; // scv 남은 체력
    static int[][][] dp = new int[61][61][61];
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    public static void main(String[] args) throws IOException{
        input();
        solve(hp, 0);
        System.out.println(min);
    }

    private static void solve(int[] hp, int cnt) {
        Arrays.sort(hp);

        int s1 = Math.max(hp[2], 0);
        int s2 = Math.max(hp[1], 0);
        int s3 = Math.max(hp[0], 0);

        if (dp[s1][s2][s3] != 0) return;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, cnt);
            return;
        }

        dp[s1][s2][s3] = cnt;

        for (int i = 0; i < 6; i++) {
            solve(new int[]{s1 - attack[i][0], s2 - attack[i][1], s3 - attack[i][2]}, cnt + 1);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cntScv = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cntScv; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }
    }
}