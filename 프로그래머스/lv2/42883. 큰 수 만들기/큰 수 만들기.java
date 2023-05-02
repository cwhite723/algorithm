import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        char[] result = new char[n-k];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char ch = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        while (stack.size() > n - k) {
            stack.pop();
        }
        
        int i = result.length-1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        
        return new String(result);
    }
}