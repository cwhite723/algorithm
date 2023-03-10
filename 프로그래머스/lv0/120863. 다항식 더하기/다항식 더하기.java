import java.io.*;
class Solution {
    public String solution(String polynomial) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] array = polynomial.split(" ");
        int num = 0;
        int xnum = 0;
        for(String s : array) {
            if(s.equals("+")) continue;
            if(!s.contains("x")) num+=Integer.parseInt(s);
            else {
                if(s.length()==1) s = s.replaceAll("x","1");
                else s = s.replaceAll("x", "");
                xnum += Integer.parseInt(s);
            }
        }
        if(xnum>=2) answer += xnum+"x";
        if(xnum==1) answer += "x"; 
        if(!answer.equals("")&&num!=0) answer += " + ";
        if(num!=0) answer += num;
        return answer;
    }
}