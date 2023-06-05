import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int countSheet;
    private static int countInterval;
    private static int[] difficulty;
    private static int[] cumulativeMistake;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        parseToCumulative();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < countInterval; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) - 1;

            int result = cumulativeMistake[end] - cumulativeMistake[start - 1];
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void parseToCumulative() {
        cumulativeMistake = new int[countSheet + 1];
        for (int i = 1; i < countSheet; i++) {
            int mistake = 0;
            if (difficulty[i] > difficulty[i + 1]) mistake = 1;
            cumulativeMistake[i] = cumulativeMistake[i - 1] + mistake;
        }
    }

    private static void input() throws IOException {
        countSheet = Integer.parseInt(br.readLine());

        difficulty = new int[countSheet + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countSheet; i++) {
            difficulty[i + 1] = Integer.parseInt(st.nextToken());
        }

        countInterval = Integer.parseInt(br.readLine());
    }
}
