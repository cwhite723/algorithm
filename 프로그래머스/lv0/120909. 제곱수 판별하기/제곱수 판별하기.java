class Solution {
    public int solution(int n) {
        int answer = 0;
        double a = Math.sqrt((double)n);
        double b = a%1;
        if(b==0) answer = 1;
        else answer = 2;
        return answer;
    }
}