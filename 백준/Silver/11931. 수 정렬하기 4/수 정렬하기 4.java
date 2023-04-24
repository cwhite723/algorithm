import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        mergeSort(0, arr.length - 1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void merge(int start, int mid, int end) {
        int leftIdx = start;
        int midIdx = mid + 1;
        int index = start;
        int i;

        while (leftIdx <= mid && midIdx <= end) {
            if (arr[leftIdx] >= arr[midIdx]) sorted[index++] = arr[leftIdx++];
            else sorted[index++] = arr[midIdx++];
        }

        if (leftIdx <= mid) {
            for (i = leftIdx; i <= mid; i++) {
                sorted[index++] = arr[i];
            }
        } else {
            for (i = midIdx; i <= end; i++) {
                sorted[index++] = arr[i];
            }
        }

        for (i = start; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }

    static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = ( start + end ) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }
}
