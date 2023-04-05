import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dnaLen = Integer.parseInt(st.nextToken());
        int pwCount = Integer.parseInt(st.nextToken());

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        String dna = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] dnaArr = new int[4];
        for(int i=0; i<4; i++) {
            dnaArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] pwArr = new int[4];
        for(int i=0; i<pwCount; i++) {
            pwArr[map.get(dna.charAt(i))]++;
        }

        int count = 0;
        for(int i=0; i<=dnaLen-pwCount; i++) {
            int temp = 0;
            for(int k=0; k<4; k++) {
                if(pwArr[k]<dnaArr[k]) {
                    break;
                } else {
                    temp++;
                }
                if(temp==4) count++;
            }
            if(i==dnaLen-pwCount) break;
            pwArr[map.get(dna.charAt(i))]--;
            pwArr[map.get(dna.charAt(i+pwCount))]++;
        }

        System.out.println(count);
    }
}