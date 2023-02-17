import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        int price = 0;

        for(int i=0; i<3; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            set.add(arr.get(i));
        }

        if(set.size()==1)
            price = 10000 + (arr.get(0)*1000);
        else if(set.size()==2) {
            if(arr.get(0)==arr.get(1))
                price = 1000 + (arr.get(0)*100);
            else
                price = 1000 + (arr.get(2)*100);
        }
        else
            price = 100 * set.last();

        System.out.println(price);
    }
}