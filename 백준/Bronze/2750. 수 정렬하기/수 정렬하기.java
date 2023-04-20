import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] sorted;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {
        sorted = new int[arr.length];
        int leftIdx = start;
        int midIdx = mid + 1;
        int index = start;
        int i;

        while (leftIdx <= mid && midIdx <= end) {
            if (arr[leftIdx] <= arr[midIdx]) sorted[index++] = arr[leftIdx++];
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

        for (i = start; i<= end; i++) {
            arr[i] = sorted[i];
        }
    }
}