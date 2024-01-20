import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] sales;
    List<Integer>[] salesInfo;
    int[][] cost;
    
    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        this.salesInfo = new ArrayList[sales.length];
        this.cost = new int[sales.length][2];

        for (int i = 0; i < sales.length; i++) {
            salesInfo[i] = new ArrayList<>();
        }

        for (int i = 0; i < links.length; i++) {
            salesInfo[links[i][0] - 1].add(links[i][1] - 1);
        }

        searchMinCost(0);
        
        return Math.min(cost[0][0], cost[0][1]);
    }
    
    void searchMinCost(int index) {
        cost[index][0] = 0;
        cost[index][1] = sales[index];
        int countChildren = salesInfo[index].size();

        if (countChildren == 0) return;

        int extraCost = Integer.MAX_VALUE;

        for (int child : salesInfo[index]) {
            searchMinCost(child);

            if (cost[child][0] < cost[child][1]) {
                cost[index][0] += cost[child][0];
                cost[index][1] += cost[child][0];

                extraCost = Math.min(extraCost, cost[child][1] - cost[child][0]);
            } else {
                cost[index][0] += cost[child][1];
                cost[index][1] += cost[child][1];

                extraCost = 0;
            }
        }

        cost[index][0] += extraCost;
    }
}
