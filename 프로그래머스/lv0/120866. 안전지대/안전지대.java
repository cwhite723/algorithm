class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] array1 = new int[]{-1, -1, -1, 1, 1, 1, 0, 0};
        int[] array2 = new int[]{-1, 0, 1, 0, 1, -1, 1, -1};
        
        for(int i=0; i<board.length; i++) {
            for(int k=0; k<board[i].length; k++) {
                if(board[i][k]==1) {
                    for(int t=0; t<8; t++) {
                        int dx = i+array1[t];
                        int dy = k+array2[t];
                        if(dx>=0&&dy>=0&&dx<=board.length-1&&dy<=board[i].length-1&&board[dx][dy]!=1) board[dx][dy] = 2;
                    }
                }
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int k=0; k<board[i].length; k++) {
                if(board[i][k]==0) answer++;
            }
        }
        return answer;
    }
}