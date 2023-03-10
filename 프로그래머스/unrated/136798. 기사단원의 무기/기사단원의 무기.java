class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int count = 0;
        for(int i=1; i<=number; i++) {
            for(int k=1; k<=Math.sqrt(i); k++) {
                if(k==Math.sqrt(i)) count += 1;
                else if(i%k==0) count += 2; 
            }
            if(count>limit) answer += power;
            else answer += count;
            count = 0;
        }
        return answer;
    }
}