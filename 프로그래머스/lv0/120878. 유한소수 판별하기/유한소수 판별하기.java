class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        int maxDivisor = divisor(a,b);
        b /= maxDivisor;
        int b2 = b;
        
        test : for(int i=2; i<=b; i++) {
            while(b%i==0) {
                if(i!=2&&i!=5) {
                    answer = 2;
                    break test;
                }
                b /= i;
            }
        }
        return answer;
    }
    
    static int divisor(int a, int b) {
        int max = 1;
        for(int i=2; i<=Math.min(a,b); i++) {
            if(a%i==0&&b%i==0) max=i;
        }
        return max;
    }
}