class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0;
        int otherCount = 0;
        
        loop : for(int i=0; i<s.length(); i++) {
            xCount=1;
            otherCount=0;
            if(i==s.length()-1) {
                answer++;
                break;
            }
            for(int k=i+1; k<s.length(); k++) {
                if(s.charAt(i)==s.charAt(k)) {
                    xCount++;
                }
                else {
                    otherCount++;
                }
                if(xCount==otherCount) {
                    answer++;
                    i=k;
                    break;
                }
                if(k==s.length()-1) {
                    answer++;
                    break loop;
                }
            }
        }
        return answer;
    }
}