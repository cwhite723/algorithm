import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String result = "";
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        for (String s : participant) {
            hashmap.put(s, hashmap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            hashmap.put(s, hashmap.get(s)-1);
        }

        for(String key : hashmap.keySet()) {
            if(hashmap.get(key)!=0) result = key;
        }
        
        return result;
    }
}