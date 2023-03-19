import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int[] arr = truck_weights.clone();
        for(int i=0; i<bridge_length; i++) {
            q.add(0);
        }

        int time = 0;
        while(!q.isEmpty()||arr.length!=0) {
            if(arr.length>0) {
                q.poll();
                int sum = q.stream().mapToInt(i->i).sum();
                if(sum+arr[0]<=weight) {
                    q.add(arr[0]);
                    arr = Arrays.copyOfRange(arr, 1, arr.length);
                    time++;
                }
                else {
                    q.add(0);
                    time++;
                }
            }
            else {
                while(!q.isEmpty()) {
                    q.poll();
                    time++;
                }
            }
        }
        
        return time;
    }
}