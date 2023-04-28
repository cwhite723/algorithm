import java.util.*;
class Solution {
    public int solution(int[] money) {
        
        //0번째 집 털고 마지막 집 안털기
        int[] first = new int[money.length];
        //0번째 집 안 털기(1번째 집 털기)
        int[] second = new int[money.length];
        
        //각 배열에 원래 배열 넣기
        first = money.clone();
        second = money.clone();
        
        first[1] = -1;
        second[0] = -1;
        first[2] += first[0];
        
        for (int i = 3; i < money.length; i++) {
            first[i] += Math.max(first[i - 2], first[i - 3]);
            second[i] += Math.max(second[i - 2], second[i - 3]);
        }
        
        int max1 = Math.max(first[money.length - 2], first[money.length - 3]);
        int max2 = Math.max(second[money.length - 1], second[money.length - 2]);
        return Math.max(max1, max2);
    }
}