import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        temp = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, n-1);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(arr[i] - (i + 1));
        }

        System.out.println(result);
    }

    static void merge(int start, int mid, int end) {
        int leftIdx = start;
        int midIdx = mid + 1;
        int tempIdx = start;
        int i;

        while (leftIdx <= mid && midIdx <= end) {
            if (arr[leftIdx] < arr[midIdx]) temp[tempIdx++] = arr[leftIdx++];
            else temp[tempIdx++] = arr[midIdx++];
        }

        if (leftIdx > mid) {
            for (i = midIdx; i <= end; i++) {
                temp[tempIdx++] = arr[i];
            }
        } else {
            for (i = leftIdx; i <= mid; i++) {
                temp[tempIdx++] = arr[i];
            }
        }

        for (i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }
}