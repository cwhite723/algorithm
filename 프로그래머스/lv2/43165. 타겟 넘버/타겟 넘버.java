class Solution {
    int[] numbers;
    int target;
    int answer;
    
    void DFS(int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        DFS(index+1, sum+numbers[index]);
        DFS(index+1, sum-numbers[index]);
    }
    public int solution(int[] numbers, int target) {
        this.answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        DFS(0,0);
        return answer;
    }
}