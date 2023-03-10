class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alphabet = new int[26];
        for(int i=0; i<keymap.length; i++) {
            for(int k=0; k<keymap[i].length(); k++) {
                if(alphabet[keymap[i].charAt(k)-65]==0) {
                    alphabet[keymap[i].charAt(k)-65] = k+1;
                }
                else if(alphabet[keymap[i].charAt(k)-65]>k+1) {
                    alphabet[keymap[i].charAt(k)-65] = k+1;
                }
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            for(int k=0; k<targets[i].length(); k++) {
                if(alphabet[targets[i].charAt(k)-65]==0) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += alphabet[targets[i].charAt(k)-65];
            }
        }
        return answer;
    }
}