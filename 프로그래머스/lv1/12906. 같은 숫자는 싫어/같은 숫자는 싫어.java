import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> array = new ArrayList<>();
        int prev = arr[0]+1;
        for(int i : arr) {
            if(prev!=i) {
                array.add(i);
                prev = i;
            }
        }
        int[] answer = array.stream().mapToInt(i->i).toArray();
        return answer;
    }
}