import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[8];
        for(int i=0; i<8; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        String result = "";
        for(int i=1; i<8; i++) {
            if(array[0]==1) {
                if(array[i]-array[i-1]==1) result = "ascending";
                else {
                    result = "mixed";
                    break;
                }
            }
            else if(array[0]==8) {
                if(array[i]-array[i-1]==-1) result = "descending";
                else {
                    result = "mixed";
                    break;
                }
            }
            else {
                result = "mixed";
                break;
            }
        }
        System.out.println(result);
    }
}