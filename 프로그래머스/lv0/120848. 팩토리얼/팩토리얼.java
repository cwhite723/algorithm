class Solution {
    public int solution(int n) {
        int answer = 0;
        int i=1;
        int num = i;
        while(num<=n) {
            num *= ++i;
            answer++;
        }
        return answer;
    }
}