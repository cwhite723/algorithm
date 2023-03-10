import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int maxIndex = numbers.length-1;
        
        return numbers[maxIndex]*numbers[maxIndex-1]>numbers[0]*numbers[1] ? numbers[maxIndex]*numbers[maxIndex-1] : numbers[0]*numbers[1];
    }
}