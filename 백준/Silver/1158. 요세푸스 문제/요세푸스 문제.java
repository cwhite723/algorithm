import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countPerson = Integer.parseInt(st.nextToken());
        int sequence = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < countPerson; i++) {
            list.add(i + 1);
        }

        int index = 0;
        while (!list.isEmpty()) {
            index = (index + sequence - 1) % list.size();
            answer.add(list.remove(index));
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < countPerson - 1; i++) {
            sb.append(answer.get(i)).append(", ");
        }
        sb.append(answer.get(countPerson - 1)).append(">");
        System.out.println(sb);
    }
}
