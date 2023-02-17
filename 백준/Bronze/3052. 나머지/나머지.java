import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<>();

        for(int i=0; i<10; i++) {
            num.add(Integer.parseInt(br.readLine()));
        }

        sb.append(countRest(num));
        System.out.println(sb.toString());
    }

    public static int countRest(ArrayList<Integer> num) {
        Set<Integer> rest = new HashSet<>();
        for(int i=0; i<10; i++) {
            rest.add((num.get(i))%42);
        }
        return rest.size();
    }
}