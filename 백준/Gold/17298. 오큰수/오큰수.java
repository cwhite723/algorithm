import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] numbers = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      int current = numbers[i];
      while (!stack.isEmpty() && numbers[stack.peek()] < current) {
        numbers[stack.pop()] = current;
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      numbers[stack.pop()] = -1;
    }

    StringBuilder sb = new StringBuilder();
    for (int i : numbers) {
      sb.append(i).append(" ");
    }
    
    System.out.println(sb.toString().trim());
  }
}