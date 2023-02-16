import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        print(arr, X);
    }
    public static void print(ArrayList<Integer> arr, int X) {
        for(int i=0; i<arr.size(); i++) {
            if (arr.get(i) < X)
                System.out.print(arr.get(i)+" ");
        }
    }
}