import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        ArrayList<Integer> array= new ArrayList<>();

        double average = 0;

        for(int i=0; i<C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                array.add(Integer.parseInt(st.nextToken()));
            }
            average = averCal(array);
            sb.append(String.format("%.3f",ratio(array, average))).append("%\n");
            array.clear();
        }

        System.out.print(sb.toString());
    }
    static float ratio (ArrayList<Integer> array, double average) {
        float count = 0f;
        for(int i=1; i<array.size(); i++) {
            if(array.get(i)>average) count++;
        }
        return count*100/array.get(0);
    }

    static double averCal (ArrayList<Integer> array) {
        int sum = 0;
        for(int i=1; i<array.size(); i++) {
            sum += array.get(i);
        }
        return sum/array.get(0);
    }
}