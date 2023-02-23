class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        int count = 0;
        
        while(num>0) {
            count ++;
            if(num%10==k) answer = count;
            num = num/10;
        }
        if(answer == 0) return -1;
        answer = (count+1)-answer;
        return answer;
    }
}