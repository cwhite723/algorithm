import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int cntScv;
    static int[] hp = new int[3]; // scv 남은 체력
    static int[][][] dp = new int[61][61][61]; // 남은 체력마다 공격횟수의 최솟값 저장
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    public static void main(String[] args) throws IOException{
        input();
        solve(hp, 0);
        output();
    }

    private static void output() {
        System.out.println(min);
    }

    private static void solve(int[] hp, int cnt) {
        // 공격 횟수의 최솟값보다 현재 공격 횟수가 크다면 확인할 필요 없다.
        if (min < cnt) return;
        
        // 남은 체력이 0 10 0일 때와 10 0 0은 결국 같은 case가 된다.
        // 따라서 정렬한 후 아래 과정을 시작한다.
        Arrays.sort(hp);

        int s1 = Math.max(hp[2], 0);
        int s2 = Math.max(hp[1], 0);
        int s3 = Math.max(hp[0], 0);

        // 이미 확인한 적이 있다면
        if (dp[s1][s2][s3] != 0) {
            dp[s1][s2][s3] = Math.min(dp[s1][s2][s3], cnt);
            return;
        }

        // 모든 체력이 0이라면 더 이상 공격할 필요가 없다.
        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, cnt);
            return;
        }

        // 그게 아니라면 현재 체력에 공격 횟수를 저장하고 이어서 탐색한다.
        dp[s1][s2][s3] = cnt;

        for (int i = 0; i < 6; i++) {
            int newS1 = Math.max(s1 - attack[i][0], 0);
            int newS2 = Math.max(s2 - attack[i][1], 0);
            int newS3 = Math.max(s3 - attack[i][2], 0);
            if (dp[newS1][newS2][newS3] != 0) continue;
            solve(new int[]{newS1, newS2, newS3}, cnt + 1);
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