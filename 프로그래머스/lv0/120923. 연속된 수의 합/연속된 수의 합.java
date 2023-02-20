class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int center = total/num;
        int start = center-((num-1)/2);
        for(int i=0; i<num; i++) {
            answer[i] = start++;
        }
        return answer;
    }
}