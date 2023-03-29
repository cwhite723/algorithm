import java.util.*;
class Solution {
    String[][] tickets;
    boolean[] visited;
    String[] answer;
    
    void dfs(String start, int count, String[] result) {
        if(count== tickets.length&&answer[0]==null) {
            answer = result;
            return;
        }

        for(int i=0; i< tickets.length; i++) {
            if(tickets[i][0].equals(start)&&!visited[i]) {
                visited[i] = true;
                String[] str = Arrays.copyOfRange(result, 0, result.length+1);
                str[str.length-1] = tickets[i][1];
                dfs(tickets[i][1], count+1, str);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length];
        this.answer = new String[tickets.length+1];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });

        dfs("ICN", 0, new String[]{"ICN"});
        return answer;
    }
}