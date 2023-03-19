import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        
        for(int i=0; i< progresses.length; i++) {
            days[i] = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            System.out.println(days[i]);
        }

        ArrayList<Integer> array = new ArrayList<>();
        int count = 1;
        int start = days[0];
        for(int i=1; i< days.length; i++) {
            if(days[i]<=start) {
                count++;
            }
            else {
                array.add(count);
                count = 1;
                start = days[i];
            }
        }
        array.add(count);

        return array.stream().mapToInt(i->i).toArray();
    }
}