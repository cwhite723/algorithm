import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = -1;
        int[] count = new int[1001];
        for(int i : array) {
            count[i]++;
        }
        
        int max = 0;
        for(int i=0; i<count.length; i++) {
            if(count[i]>=max) {
                if(count[i]==max) answer = -1;
                else {
                    max = count[i];
                    answer = i;
                }
            }
        }
        return answer;
    }
}