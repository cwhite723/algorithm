import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String deleteString = "ad";
        List<String> answerList = new ArrayList<>();

        for (String str : strArr) {
            if (!str.contains(deleteString)) answerList.add(str);
        }

        return answerList.toArray(String[]::new);
    }
}