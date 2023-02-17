import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> studentnumber = new ArrayList<>();
        for(int i=0; i<30; i++) {
            studentnumber.add(i+1);
        }

        for(int i=0; i<28; i++) {
            int submit = Integer.parseInt(br.readLine());
            if(studentnumber.contains(submit)) {
                studentnumber.remove(studentnumber.indexOf(submit));
            }
        }
        
        System.out.println(Collections.min(studentnumber));
        System.out.println(Collections.max(studentnumber));

    }
}