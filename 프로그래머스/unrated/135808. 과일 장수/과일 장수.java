import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;
        int min = k+1;
        Arrays.sort(score); //1112233
        for(int i=score.length-1; i>=score.length%m; i--) {
            if(min>score[i]) min = score[i];
            count++;
            if(count==m) {
                answer += min*m;
                count = 0;
            }
        }
        return answer;
    }
}