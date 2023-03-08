class Solution {
    public int solution(int[] sides) {
        int answer = 2;
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<3; i++) {
            if(sides[i]>max) {
                max = sides[i];
                maxIndex = i;
            }
        }
        int sum = 0;
        for(int i=0; i<3; i++) {
            if(i!=maxIndex) {
                sum += sides[i];
            }
        }
        if(sum>sides[maxIndex]) answer=1;
        return answer;
    }
}