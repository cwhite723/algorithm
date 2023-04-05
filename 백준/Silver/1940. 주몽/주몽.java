import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[n];
        for(int i=0; i<n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int startIndex = 0;
        int endIndex = n-1;

        Arrays.sort(numArr);
        while(startIndex<endIndex) {
            if(numArr[startIndex]+numArr[endIndex]<m) {
                startIndex++;
            } else if(numArr[startIndex]+numArr[endIndex]>m) {
                endIndex--;
            } else {
                count++;
                startIndex++;
                endIndex--;
            }
        }
        System.out.println(count);
    }
}