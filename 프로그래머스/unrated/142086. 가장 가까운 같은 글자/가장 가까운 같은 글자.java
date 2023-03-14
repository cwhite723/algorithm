class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        boolean[] alphabet = new boolean[26];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(alphabet[c-'a']==false) answer[i]=-1;
            else {
                int k=i-1;
                while(s.charAt(k)!=c) {
                    k--;
                }
                answer[i] = i-k;
                
            }
            alphabet[c-'a'] = true;
        }
        return answer;
    }
}