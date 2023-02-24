import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); //XXYY에서 YY
            int W = Integer.parseInt(st.nextToken()); //XXYY에서 XX
            int N = Integer.parseInt(st.nextToken()); //몇 번째 손님?

            int count = 1;
            int[][] roomNum = new int[W][H];
            hotel : for(int k=0; k<W; k++) {
                for (int p=0; p<H; p++) {
                    roomNum[k][p] = count;
                    if (count == N) {
                        sb.append((p+1)*100+k+1).append("\n");
                        break hotel;
                    }
                    count++;
                }
            }
        }
        System.out.println(sb.toString());
    }
}