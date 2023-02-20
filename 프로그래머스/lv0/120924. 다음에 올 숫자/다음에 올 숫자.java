class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int difference1, difference2, ratio;

        difference1 = common[1]-common[0];
        difference2 = common[2]-common[1];
        
        if(difference1 == difference2)
            answer = common[common.length-1] + difference1;
        else {
            ratio = common[1]/common[0];
            answer = common[common.length-1] * ratio;
        }
            
        
        return answer;
    }
}