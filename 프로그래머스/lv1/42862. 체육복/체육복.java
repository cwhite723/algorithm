import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean check = false;
        int answer = n-lost.length;
        
        for(int i=0; i<lost.length; i++) {
            for(int k=0; k<reserve.length; k++) {
                if(lost[i]==reserve[k]) {
                    lost[i] = -1;
                    reserve[k] = -1;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++) {
            for(int k=0; k<reserve.length; k++) {
                if(lost[i]!=-1&&(lost[i]-1==reserve[k]||lost[i]+1==reserve[k])) {
                    lost[i] = -1;
                    reserve[k] = -1;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++) {
            if(lost[i]==-1) {
                answer += 1;
            }
        }
        
        return answer;
    }
}