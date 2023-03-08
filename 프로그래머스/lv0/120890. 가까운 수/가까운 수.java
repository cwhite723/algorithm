import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 100;
        Arrays.sort(array);
        for(int i=0; i<array.length; i++) {
            int abs = Math.abs(array[i]-n);
            if(abs<min) {
                min=abs;
                answer=array[i];
            }
        }
        return answer;
    }
}