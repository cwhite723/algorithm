import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i=people.length-1;
        int k = 0;
        while(k<=i) {
            if(people[i]+people[k]<=limit) k++;
            i--;
            answer++;
        }
        return answer;
    }
}