import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        if(grad(dots[0], dots[1])==grad(dots[2], dots[3])) return 1;
        else if(grad(dots[0], dots[2])==grad(dots[1], dots[3])) return 1;
        else if(grad(dots[0], dots[3])==grad(dots[1], dots[2])) return 1;
        return answer;
    }
    
    static double grad(int[] a, int[] b) {
        if(a[0]==b[0]) return Double.POSITIVE_INFINITY;
        return (double)(a[1]-b[1])/(double)(a[0]-b[0]);
    }
}