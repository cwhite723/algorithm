import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        
        char[] Arr = my_string.toCharArray();
        Arrays.sort(Arr);
        answer = new String(Arr);
        return answer;
    }
}