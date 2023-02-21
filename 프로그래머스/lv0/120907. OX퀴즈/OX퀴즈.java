class Solution {
    public String[] solution(String[] quiz) {
        String[] str;
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++) {
            str = quiz[i].split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[2]);
            int result = Integer.parseInt(str[4]);
            if(str[1].equals("-")) {
                answer[i] = ((x-y)==result) ? "O" : "X";
            }
            else {
                answer[i] = ((x+y)==result) ? "O" : "X";
            }
        }
        return answer;
    }
}