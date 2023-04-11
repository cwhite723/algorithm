import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int count = 0;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static void queen(int depth) {
        if(depth == n) {
            count++;
            return;
        }

        for(int i=0; i<n; i++) {
            arr[depth] = i;
            if(Possibility(depth)) {
                queen(depth+1);
            }
        }
    }

    private static boolean Possibility(int depth) {

        for (int i=0; i<depth; i++) {
            if (arr[depth] == arr[i]) {
                return false;
            }

            else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        queen(0);
        System.out.println(count);
    }
}