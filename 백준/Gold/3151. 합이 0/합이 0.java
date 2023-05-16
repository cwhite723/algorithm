import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int cntStudent;
    private static int[] skill;
    private static long answer = 0L;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void solve() {
        for (int i = 0; i < cntStudent; i++) {
            if (skill[i] > 0) break;

            int leftIdx = i + 1;
            int rightIdx = cntStudent - 1;

            while (leftIdx < rightIdx) {

                int cntLeft = 1;
                int cntRight = 1;
                
                int cur = skill[i] + skill[leftIdx] + skill[rightIdx];
                
                if (cur == 0) {
                    if (skill[leftIdx] == skill[rightIdx]) {
                        int temp = rightIdx - leftIdx + 1;
                        answer += temp * (temp - 1) / 2;
                        break;
                    }

                    while (leftIdx + 1 < rightIdx && skill[leftIdx] == skill[leftIdx + 1]) {
                        cntLeft++;
                        leftIdx++;
                    }
                    while (rightIdx - 1 > leftIdx && skill[rightIdx] == skill[rightIdx - 1]) {
                        cntRight++;
                        rightIdx--;
                    }

                    answer += cntLeft * cntRight;
                }

                if (cur > 0) {
                    rightIdx--;
                } else {
                    leftIdx++;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cntStudent = Integer.parseInt(br.readLine());
        
        skill = new int[cntStudent];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cntStudent; i++) {
            skill[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(skill);
    }
}
