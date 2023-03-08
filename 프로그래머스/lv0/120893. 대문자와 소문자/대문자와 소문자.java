class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++) {
            char a;
            if('a'<=my_string.charAt(i)&&my_string.charAt(i)<='z') {
                a = (char)(my_string.charAt(i)-32);
            }
            else {
                a = (char)(my_string.charAt(i)+32);
            }
            answer += String.valueOf(a);
        }
        return answer;
    }
}