class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while(chicken>=10) {
            int service = chicken/10;
            int remain = chicken%10;
            chicken = service + remain;
            answer += service;
        }
        
        return answer;
    }
}