import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hashmap = new HashMap<>();
        String mbti="";
        int count=0;
        
        for(int i=0; i< choices.length; i++) {
            if(choices[i]>4) {
                mbti = String.valueOf(survey[i].charAt(1));
                count = choices[i]-4;
            }
            else if(choices[i]<4) {
                mbti = String.valueOf(survey[i].charAt(0));
                count = 4-choices[i];
            }
            else continue;
            hashmap.put(mbti, hashmap.getOrDefault(mbti,0)+count);
        }
        sb.append(hashmap.getOrDefault("R",0)>=hashmap.getOrDefault("T",0) ? "R" : "T");
        sb.append(hashmap.getOrDefault("C",0)>=hashmap.getOrDefault("F",0) ? "C" : "F");
        sb.append(hashmap.getOrDefault("J",0)>=hashmap.getOrDefault("M",0) ? "J" : "M");
        sb.append(hashmap.getOrDefault("A",0)>=hashmap.getOrDefault("N",0) ? "A" : "N");
        return sb.toString();
    }
}