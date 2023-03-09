import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        Arrays.sort(spell);
        for(int i=0; i<dic.length; i++) {
            String[] arr = dic[i].split("");
            Arrays.sort(arr);
            if(spell.length==arr.length) {
                if(Arrays.toString(arr).equals(Arrays.toString(spell))) answer = 1;
            }
        }
        return answer;
    }
}