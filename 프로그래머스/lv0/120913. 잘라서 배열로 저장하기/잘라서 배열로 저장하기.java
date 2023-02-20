class Solution {
    public String[] solution(String my_str, int n) {
        
        int size;
        int start = 0;
        
        String[] result;
        
        if(my_str.length()%n==0)
            size = my_str.length()/n;
        else
            size = my_str.length()/n+1;
        
        result = new String[size];

        for(int i=0; i<size-1; i++) {
            result[i] = my_str.substring(start,start+n);
            start += n;
        }
        result[size-1] = my_str.substring(start,my_str.length());
        
        return result;
    }
}