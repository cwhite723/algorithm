import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> array = new ArrayList<>();

        for(int i=0; i<N; i++) {
            array.add(Integer.parseInt(br.readLine()));
        }

        TreeSet<Integer> newArray = new TreeSet<>(array);
        Iterator iter = newArray.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}