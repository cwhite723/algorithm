import java.util.*;
class Solution {
    public int[] solution(int[] prices) {

        ArrayList<Integer> array = new ArrayList<>();

        for(int i=0; i< prices.length; i++) {
            int time = 0;
            for(int k=i+1; k< prices.length; k++) {
                time++;
                if(prices[k]<prices[i]) {
                    break;
                }
            }
            array.add(time);
        }
        
        return array.stream().mapToInt(i->i).toArray();
    }
}