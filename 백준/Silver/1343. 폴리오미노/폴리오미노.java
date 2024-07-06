import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean flag = true;
        int count = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (target == 'X') count++;
            else {
                while (count >= 4) {
                    answer.append("AAAA");
                    count -= 4;
                }
                while (count >= 2) {
                    answer.append("BB");
                    count -= 2;
                }

                if (count > 0) flag = false;
                answer.append(".");
                count = 0;
            }
        }

        while (count >= 4) {
            answer.append("AAAA");
            count -= 4;
        }
        while (count >= 2) {
            answer.append("BB");
            count -= 2;
        }

        if (count > 0) flag = false;

        if (!flag) System.out.println(-1);
        else System.out.println(answer.toString());
    }
}
