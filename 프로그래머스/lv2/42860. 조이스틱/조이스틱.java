class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;
        int index = 0;
        int move = len - 1;
        
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' + 1 - c);
            
            index = i + 1;
            while (index < len && name.charAt(index) == 'A') {
                index++;
            }
            
            move = Math.min(move, (i * 2) + len - index);
            move = Math.min(move, (len - index) * 2 + i);
        }
        
        return answer + move;
    }
}