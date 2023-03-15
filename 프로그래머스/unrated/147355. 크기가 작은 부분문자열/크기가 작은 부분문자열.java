class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        
        for(int i=0; i<=t.length()-len; i++) {
            int j=0;
            for(int k=i; k<i+len; k++) {
                if(t.charAt(k)-'0'<p.charAt(j)-'0') {
                    answer++;
                    break;
                }
                else if(t.charAt(k)-'0'==p.charAt(j)-'0') {
                    if(k==i+len-1) answer++;
                    j++;
                }
                else break;
            }
        }
        return answer;
    }
}