import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int roadDis = 0; // 고속도로 길이
    static int curRest = 0; // 현재 휴게소 수
    static int addRest = 0; // 추가할 휴게소 수
    static int[] locRest; // 현재 휴게소들의 위치
    static int[] difRest; // 휴게소 사이의 거리
    static int result = 0;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        curRest = Integer.parseInt(st.nextToken());
        addRest = Integer.parseInt(st.nextToken());
        roadDis = Integer.parseInt(st.nextToken());

        locRest = new int[curRest + 2];
        difRest = new int[curRest + 1];
        locRest[0] = 0;
        st = new StringTokenizer(br.readLine());
        int index = 1;
        while (st.hasMoreTokens()) {
            locRest[index++] = Integer.parseInt(st.nextToken());
        }
        locRest[locRest.length - 1] = roadDis;
        Arrays.sort(locRest);
    }
    
    // 휴게소 사이의 거리를 기준으로 이분탐색을 한다.
    public static void main(String[] args) throws IOException {
        input();
        locRestToDifRest();
        binarySearch();
        System.out.println(result);
    }

    // 현재 위치 배열을 휴게소 간 거리 배열로 변환한다.
    private static void locRestToDifRest() {
        for (int i = 1; i < locRest.length; i++) {
            difRest[i - 1] = locRest[i] - locRest[i - 1] - 1;
        }
    }

    private static void binarySearch() {
        int start = 1;
        int end = roadDis;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sumDif = 0;

            for (int i = 0; i < difRest.length; i++) {
                sumDif += difRest[i] / mid;
            }

            if (sumDif > addRest) start = mid + 1;
            else end = mid - 1;
        }

        result = start;
    }
}
