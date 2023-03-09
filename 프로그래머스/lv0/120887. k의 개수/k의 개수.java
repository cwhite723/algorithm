class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int t=i; t<=j; t++) {
            String[] str = String.valueOf(t).split("");
            for(String s : str) {
                if(Integer.parseInt(s)==k) answer++;
            }
        }
        return answer;
    }
}