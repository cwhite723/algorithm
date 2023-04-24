import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] id;
    static int[] power;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //칭호의 개수
        int m = Integer.parseInt(st.nextToken()); //캐릭터 개수

        id = new String[n];
        power = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String maxId = st.nextToken();
            Integer maxPower = Integer.parseInt(st.nextToken());
            id[i] = maxId;
            power[i] = maxPower;
        }

        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(br.readLine());
            sb.append(binarySearch(cur)).append("\n");
        }

        System.out.println(sb);
    }

    static String binarySearch(int cur) {
        int start = 0;
        int end = power.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (cur > power[mid]) start = mid + 1;
            else end = mid - 1;
        }

        return id[start];
    }
}
