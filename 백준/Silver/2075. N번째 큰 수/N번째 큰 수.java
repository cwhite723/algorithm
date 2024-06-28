import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[][] array = new int[number][number];

        for (int i = 0; i < number; i++) {
            array[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            for (int k = 0; k < number; k++) {
                list.add(array[i][k]);
            }
        }

        list.sort(Comparator.reverseOrder());
        System.out.println(list.get(number - 1));
    }
}
