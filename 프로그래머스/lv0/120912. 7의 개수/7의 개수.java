class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i=0; i<array.length; i++) {
            while(array[i]!=0) {
                int units = array[i]%10;
            
                if(units!=0&&units%7==0) {
                    answer++;
                }
                array[i] = array[i]/10;
            }
        }
        return answer;
    }
}