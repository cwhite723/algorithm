class Solution {
    public int solution(String s) {
        String[] regex = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String[] replacement = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(regex[i], replacement[i]);
        }
        
        return Integer.parseInt(s);
    }
}