class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        int sum = sides[0]+sides[1];
        int count = sum-max-1;
        for(int i=1; i<=max; i++) {
            if(i+min > max) count += 1;
        }
        answer = count;
        return answer;
    }
}