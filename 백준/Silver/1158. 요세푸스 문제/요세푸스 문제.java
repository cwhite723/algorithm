import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countPerson = Integer.parseInt(st.nextToken());
        int sequence = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < countPerson; i++) {
            list.add(i + 1);
        }

        StringBuilder answer = new StringBuilder("<");
        int index = 0;
        while (list.size() > 1) {
            index = (index + sequence - 1) % list.size();
            answer.append(list.remove(index)).append(", ");
        }
        answer.append(list.get(0)).append(">");
        System.out.println(answer);
    }
}
