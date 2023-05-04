import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] r1, int[] r2) {
                return r1[1] - r2[1];
            }
        });
        
        int cam = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            if (route[0] > cam) {
                cam = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}