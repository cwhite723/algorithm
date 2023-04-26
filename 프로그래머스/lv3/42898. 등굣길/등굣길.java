class Solution {
    int dev = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];
        
        arr[0][0] = 1;
        for (int[] i : puddles) {
            arr[i[1] - 1][i[0] - 1] = -1;
        }
        
        //arr[i][k] = arr[i-1][k] + arr[i][k-1]
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (arr[i][k] == -1) {
                    arr[i][k] = 0;
                    continue;
                }
                
                if (i != 0) arr[i][k] += arr[i-1][k] % dev;
                if (k != 0) arr[i][k] += arr[i][k-1] % dev;
            }
        }
        
        return arr[n-1][m-1] % dev;
    }
}