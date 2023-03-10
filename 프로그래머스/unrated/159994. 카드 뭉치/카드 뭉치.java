import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int index = -1;
        int count = 0;
        for(String s : cards1) {
            int newIndex = Arrays.stream(goal).collect(Collectors.toList()).indexOf(s);
            if(newIndex<0) break;
            if(newIndex<index) return "No";
            index = newIndex;
            count++;
        }
        
        index = -1;
        for(String s : cards2) {
            int newIndex = Arrays.stream(goal).collect(Collectors.toList()).indexOf(s);
            if(newIndex<0) break;
            if(newIndex<index) return "No";
            index = newIndex;
            count++;
        }
        
        if(count!=goal.length) return "No";
        
        return answer;
    }
}