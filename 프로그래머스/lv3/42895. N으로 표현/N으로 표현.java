import java.util.*;
class Solution {
    int N, number;
    List<HashSet<Integer>> list;
    HashSet<Integer> cur;
    
    public int solution(int N, int number) {
        this.N = N;
        this.number = number;
        this.list = new ArrayList<>();
        
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<Integer>());
        }
        list.get(1).add(N);
        
        if (number == N) return 1;
        
        int result = dp();
        return result;
    }
    
    private int dp() {
        for (int i = 2; i <= 8; i++) {
            cur = list.get(i);
            for (int k = 1; k < i; k++) {
                HashSet<Integer> set1 = list.get(k);
                HashSet<Integer> set2 = list.get(i - k);
                
                if (merge(set1, set2, i)) return i;
            }
        }
        return -1;
    }
    
    private boolean merge(HashSet<Integer> set1, HashSet<Integer> set2, int count) {
        for (int i : set1) {
            for (int k : set2) {
                cur.add(i + k);
                cur.add(i * k);
                cur.add(i - k);
                if (i != 0 && k != 0) cur.add(i / k);
            }
        }
        
        cur.add(Integer.parseInt(String.valueOf(N).repeat(count)));
        
        if (cur.contains(number)) return true;
        else return false;
    }
}