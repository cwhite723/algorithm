class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int k = 0;
        for(String s : quiz) {
            String[] str = s.split(" ");
            int a = 0;
            if(str[1].equals("+")) {
                a = Integer.parseInt(str[0])+Integer.parseInt(str[2]);
            }
            else {
                a = Integer.parseInt(str[0])-Integer.parseInt(str[2]);
            }
            
            if(a == Integer.parseInt(str[4])) answer[k++] = "O";
            else answer[k++] = "X";
        }
        return answer;
    }
}