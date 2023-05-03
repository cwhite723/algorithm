import java.util.*;
class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            
            int startParent = findParent(start);
            int endParent = findParent(end);
            
            if (startParent == endParent) continue;
            
            answer += cost;
            parent[endParent] = startParent;
        }
        
        return answer;
    }
    
    public int findParent(int n) {
        if (parent[n] == n) return n;
        return parent[n] = findParent(parent[n]);
    }
}