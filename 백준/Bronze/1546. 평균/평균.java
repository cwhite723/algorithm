import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Double> score = new ArrayList<>();

        int numberSubject = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberSubject; i++)
            score.add(Double.parseDouble(st.nextToken()));

        double max = Collections.max(score);
        newScore(score, max);

        sb.append(averageCal(score, numberSubject));
        System.out.println(sb.toString()+"\n");
    }

    public static void newScore(ArrayList<Double> score, double max) {
        for(int i=0; i<score.size(); i++) {
            score.set(i,score.get(i)/max*100);
        }
    }
    public static double averageCal(ArrayList<Double> score, double numberSubject) {
        double sum = 0;
        for(double i: score)
            sum += i;
        return sum/numberSubject;
    }

}