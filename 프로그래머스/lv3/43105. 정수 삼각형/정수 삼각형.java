import java.util.*;
class Solution {
    int[][] triangle;
    int[][] total;
    
    public int solution(int[][] triangle) {
        this.triangle = triangle;
        this.total = triangle;
        int size = triangle.length;
        total[0][0] = triangle[0][0];
        
        for (int i = 1; i < size; i++) {
            for (int k = 0; k <= i; k++) {
                if (k == 0) total[i][k] += triangle[i-1][0];
                else if (k == i) total[i][k] += triangle[i - 1][i - 1];
                else total[i][k] += Math.max(triangle[i - 1][k - 1], triangle[i - 1][k]);
            }
        }
        
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, total[size - 1][i]);
        }
        return max;
    }
}