import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int move = 0;
    static int target;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arraySize = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[arraySize + 1];
        for (int i = 1; i <= arraySize; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        try {
            heapSort(array);
            System.out.println(-1);
        } catch (RuntimeException e) {
            System.out.println(sb.toString());
        }
    }

    static void swap(int[] array, int x, int y) {
        move++;

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

        if (move == target) {
            for (int i = 1; i < array.length; i++) {
                sb.append(array[i] + " ");
            }
            throw new RuntimeException();
        }
    }
    static void heapSort(int[] array) {
        buildMinHeap(array, array.length - 1);
        for (int i = array.length - 1; i > 1; i--) {
            swap(array, 1, i);
            heapify(array, 1, i - 1);
        }
    }

    static void buildMinHeap(int[] array, int lastIndex) {
        for (int i = lastIndex / 2; i > 0; i--) {
            heapify(array, i, lastIndex);
        }
    }

    static void heapify(int[] array, int k, int lastInex) {
        int left = k * 2;
        int right = left + 1;
        int smaller;
        if (right <= lastInex) {
            if (array[left] < array[right]) smaller = left;
            else smaller = right;
        } else if (left <= lastInex) {
            smaller = left;
        } else return;

        if (array[smaller] < array[k]) {
            swap(array, k, smaller);
            heapify(array, smaller, lastInex);
        }
    }
}
