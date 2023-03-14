import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] result = new int[score.length];
        for(int i=0; i<score.length; i++) {
            int[] arr = Arrays.copyOfRange(score,0,i+1);
            Arrays.sort(arr);
            if(i<k) result[i] = arr[0];
            else result[i] = arr[arr.length-k];
        }
        return result;
    }
}