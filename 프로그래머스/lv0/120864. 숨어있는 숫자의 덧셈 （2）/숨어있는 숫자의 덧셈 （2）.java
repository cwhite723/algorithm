class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String str = "";
        
        for(int i=0; i<my_string.length(); i++) {
            if(my_string.charAt(i)-'0'<10) {
                char c = my_string.charAt(i);
                str += Character.toString(c);
            }
            else {
                if(str.length()!=0) {
                    answer += Integer.parseInt(str);
                    str = "";
                }
            }
        }
        if(str.length()!=0) {
                    answer += Integer.parseInt(str);
                    str = "";
                }
        return answer;
    }
}