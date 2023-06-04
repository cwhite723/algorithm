import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int MIN_NUMBER = 3;

    private static int totalStudents;
    private static int countSleepStudents;
    private static int codeReceiveStudents;
    private static int intervalCount;
    private static boolean[] isReceiveCode;
    private static int[] totalNotAttend;
    private static List<Integer> sleepStudentsNumber;

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        totalStudents = Integer.parseInt(st.nextToken());
        countSleepStudents = Integer.parseInt(st.nextToken());
        codeReceiveStudents = Integer.parseInt(st.nextToken());
        intervalCount = Integer.parseInt(st.nextToken());

        isReceiveCode = new boolean[totalStudents + MIN_NUMBER];
        totalNotAttend = new int[totalStudents + MIN_NUMBER];
        sleepStudentsNumber = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            sleepStudentsNumber.add(number);
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());

            if (sleepStudentsNumber.contains(number)) {
                continue;
            } else {
                isReceiveCode[number] = true;
                sendCode(number);
            }
        }

        for (int i = MIN_NUMBER; i < totalStudents + MIN_NUMBER; i++) {
            int notAttend = 0;
            if (!isReceiveCode[i]) notAttend = 1;
            totalNotAttend[i] = totalNotAttend[i - 1] + notAttend;
        }

        for (int i = 0; i < intervalCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(totalNotAttend[end] - totalNotAttend[start - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void sendCode(int number) {
        int i = 2;
        while (number * i < totalStudents + MIN_NUMBER) {
            int next = number * i++;
            if (!sleepStudentsNumber.contains(next)) {
                isReceiveCode[next] = true;
            }
        }
    }
}
