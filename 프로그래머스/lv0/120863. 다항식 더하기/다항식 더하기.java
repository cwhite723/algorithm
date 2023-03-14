class Solution {
    public String solution(String polynomial) {
        StringBuilder sb = new StringBuilder();
        String[] str = polynomial.split(" ");

        int xValue = 0;
        int value = 0;

        for(int i=0; i<str.length; i++) {
            if(str[i].contains("x")) {
                if(str[i].length()==1) xValue += 1;
                else xValue += Integer.parseInt(str[i].substring(0, str[i].length()-1));
            }
            else if(!str[i].equals("+")) {
                value += Integer.parseInt(str[i]);
            }
        }

        if(xValue>1) sb.append(xValue).append("x");
        else if(xValue>0) sb.append("x");
        if(xValue>0&&value>0) sb.append(" + ");
        if(value>0) sb.append(value);
        return sb.toString();
    }
}