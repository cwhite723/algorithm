class Solution {
    public String solution(String my_string) {
        String answer = "";
        boolean[] array = new boolean[123];
        for(int i=0; i<my_string.length(); i++) {
            if(my_string.charAt(i)==' '&&array[0]==false) {
                answer += my_string.charAt(i);
                array[0]=true;
            }
            else if(my_string.charAt(i)!=' ') {
                int index = (int)my_string.charAt(i);
                if(array[index]==false) {
                    answer += my_string.charAt(i);
                    array[index] = true;
                }
            }
        }
        return answer;
    }
}