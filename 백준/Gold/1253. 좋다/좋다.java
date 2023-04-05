import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[n];
        for(int i=0; i<n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        int count = 0;
        for(int i=0; i<n; i++) {
            int startIndex = 0;
            int endIndex = n-1;
            while(startIndex<endIndex) {
                if(numArr[startIndex]+numArr[endIndex]==numArr[i]) {
                    if(startIndex!=i&&endIndex!=i) {
                        count++;
                        break;
                    } else if(startIndex==i) {
                        startIndex++;
                    } else {
                        endIndex--;
                    }
                } else if(numArr[startIndex]+numArr[endIndex]<numArr[i]) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }
        if(n<=2) System.out.println(0);
        else System.out.println(count);
    }
}