import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for(int i=0; i<X.length(); i++) {
            xCount[X.charAt(i)-'0']++;
        }
        for(int i=0; i<Y.length(); i++) {
            yCount[Y.charAt(i)-'0']++;
        }
        
        for(int i=9; i>=0; i--) {
            int count = Math.min(xCount[i],yCount[i]);
            if(i==0&&sb.length()==0&&count>1) sb.append("0");
            else if(count!=0) {
                for(int k=0; k<count; k++) sb.append(i);
            }
        }
        if(sb.length()==0) sb.append("-1");
        return sb.toString();
    }
}