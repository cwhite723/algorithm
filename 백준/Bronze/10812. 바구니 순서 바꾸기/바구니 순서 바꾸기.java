import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //바구니 갯수 N, 회전시킬 횟수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        for(int i = 0; i<N; i++) {
            array[i] = i+1;
        }

        int[] copyArray = new int[N];
        //회전시킬 바구니 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1; //0
            int end = Integer.parseInt(st.nextToken())-1; //5
            int mid = Integer.parseInt(st.nextToken())-1;//3

            //start 앞, end 뒤 바구니는 새로운 배열 같은 인덱스에 복사
            for(int k=0; k<N; k++) {
                if(k<start||k>end) copyArray[k] = array[k];
            }

            //원래 배열 mid~end를 새로운 배열 start로 복사
            for(int k=mid,j=start; k<=end; k++,j++) {
                copyArray[j] = array[k];
            }

            //원래 배열 end~를 새로운 배열 mid~start로 복사
            for(int k=end,j=mid-1; j>=start; k--,j--) {
                copyArray[k] = array[j];
            }
            System.arraycopy(copyArray,0,array,0, N);
        }

        for(int i=0; i<copyArray.length; i++) {
            System.out.print(copyArray[i]+" ");
        }
    }
}