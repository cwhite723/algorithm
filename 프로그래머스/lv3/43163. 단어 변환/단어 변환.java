class Solution {
    String[] words;
    String target;
    int answer;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        answer = 0;
        visited = new boolean[words.length];
        DFS(begin, 0);
        
        return answer;
    }
    
    void DFS(String begin, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }
        
        for(int k=0; k<words.length; k++) {
            int len = 0;
            if(!visited[k]) {
                for(int i=0; i<words[k].length(); i++) {
                    if(begin.charAt(i)==words[k].charAt(i)) len++;
                }
                if(len == begin.length()-1) {
                    visited[k] = true;
                    DFS(words[k], count+1);
                    visited[k] = false;
                }
            }
            
        }
    }
}