class Solution {
    public int solution(String A, String B) {
        int answer=0;
        String copy = A;

        for(int i=0; i<A.length(); i++) {
            if(copy.equals(B))
                return answer;

            String a = copy.substring(A.length()-1);
            copy = a + copy.substring(0, A.length()-1);
            answer ++;
        }
        
        return -1;
    }
}