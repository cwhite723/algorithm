import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        int count=0;
        for(int i=1; i<=n; i++) {
            if(n%i==0) count++;
        }
        int k=0;
        int[] answer = new int[count];
        
        for(int i=1; i<=n; i++) {
            if(n%i==0) answer[k++] = i;
        }
        return answer;
    }
}