import java.util.*;
class Solution {
    int n;
    int s;
    int a;
    int b;
    int[][] fares;
    final int infinity = 30000000;
    int answer;
    
    void bfs(int[][] dist) {
        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            if(dist[s][i] != infinity && dist[s][a] != infinity && dist[s][b] != infinity){
                answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
            }
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        this.s = s;
        this.a = a;
        this.b = b;
        this.fares = fares;
        this.answer = infinity;
        int[][] dist = new int[n+1][n+1];

        for(int i=0; i<=n; i++) {
            Arrays.fill(dist[i], infinity);
        }
        for(int i=0; i<=n; i++) {
            dist[i][i] = 0;
        }
        for(int i=0; i< fares.length; i++) {
            dist[fares[i][0]][fares[i][1]] = fares[i][2];
            dist[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        bfs(dist);
        
        return answer;
    }
}