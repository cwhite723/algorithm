class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.replaceAll("a","");
        my_string = my_string.replaceAll("e","");
        my_string = my_string.replaceAll("o","");
        my_string = my_string.replaceAll("u","");
        my_string = my_string.replaceAll("i","");
        
        answer = my_string;
        return answer;
    }
}