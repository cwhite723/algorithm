class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        boolean[] alphabet = new boolean[26];
        String answer = "";
        
        for(int i=0; i<skip.length(); i++) {
            alphabet[skip.charAt(i)-97] = true;
        }
        
        for(int i=0; i<s.length(); i++) {
            int ind = s.charAt(i)-97;
            for(int k=0; k<index; k++) {
                ind++;
                if(ind==26) ind=0;
                while(alphabet[ind]) {
                    ind++;
                    if(ind==26) ind=0;
                }
            }
            sb.append((char)(ind+97));
        }
        answer = sb.toString();
        return answer;
    }
}