import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=2; n>1; i++) {
            while(n%i==0) {
                array.add(i);
                n /= i;
            }
        }
        return array.stream().distinct().sorted().mapToInt(i->i).toArray();
        
    }
}