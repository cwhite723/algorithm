import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n = 0;
    static long k = 0;
    static long[] arr = {};
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) answer++;
        }

        int leftIdx = 0;
        int rightIdx = leftIdx + 1;

        // 1 2 3 4 5
        while (leftIdx < rightIdx && rightIdx < n) {
            if (arr[rightIdx] - arr[leftIdx] > k) {
                answer += n - rightIdx;
                leftIdx++;
            } else {
                rightIdx++;
            }
        }
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
        }
        k = Long.parseLong(br.readLine());
    }
}