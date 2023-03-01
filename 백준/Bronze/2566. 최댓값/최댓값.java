import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] array = new int[9][9];
        
        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k<9; k++) {
                array[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        int rowIndex = 0;
        int columnIndex=0;
        int max=-1;
        
        for(int i=0; i<9; i++) {
            for(int k=0; k<9; k++) {
                if(array[i][k]>max) {
                    max = array[i][k];
                    rowIndex=i+1;
                    columnIndex=k+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(rowIndex + " " + columnIndex);
    }
}