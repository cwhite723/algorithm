class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int center = total/num;
        answer[0] = center-(num-1)/2;
        for(int i=1; i<num; i++) {
            answer[i] = answer[i-1]+1;
        }
        return answer;
    }
}