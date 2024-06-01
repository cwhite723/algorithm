import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int count = 0;
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                answerList.add(count);
                count = 0;
            } else {
                count++;
            }
        }
        answerList.add(count);
        
        return answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}