class Solution {
    public String solution(String s) {
        String answer = "";
        int[] abc = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            abc[s.charAt(i)-97]++;
        }
        for(int i=0; i<abc.length; i++) {
            if(abc[i]==1) answer += (char)(i+97);
        }
        return answer;
    }
}