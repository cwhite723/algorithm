import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        my_string = my_string.replaceAll("[a-zA-Z]","");
        String[] str = my_string.split("");
        
        return Arrays.stream(str).sorted().mapToInt(Integer::parseInt).toArray();
    }
}