import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i< priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }

        int count = 0;
        while(!q.isEmpty()) {
            int[] start = q.poll();
            if(q.isEmpty()) {
                count++;
                break;
            }
            int max = q.stream().map(i->i[1]).mapToInt(i->i).max().getAsInt();
            if(start[1]<max) {
                q.add(start);
            }
            else {
                count++;
                if(start[0]==location) break;
            }
        }
        
        return count;
    }
}