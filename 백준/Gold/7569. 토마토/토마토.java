import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int floor = Integer.parseInt(st.nextToken());

        int total = 0; //총 토마토
        int ripe = 0; // 익은 토마토
        int[][][] tomato = new int[floor][row][column];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<floor; i++) {
            for(int k=0; k<row; k++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<column; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    tomato[i][k][j] = temp;
                    if(temp == 1) {
                        ripe++;
                        queue.add(new int[]{i, k, j});
                    }
                    else if(temp == 0) total++;
                }
            }
        }
        total += ripe;

        int[] df = {0, 0, 1, 0, -1, 0};
        int[] dr = {0, 0, 0, 1, 0, -1};
        int[] dc = {-1, 1, 0, 0, 0, 0};

        int days = 0;
        //1 익음 0 익지 않음 -1 없음
        while(!queue.isEmpty()) {
            int[] start = queue.poll();
            int currentFloor = start[0];
            int currentRow = start[1];
            int currentColumn = start[2];

            for(int t=0; t<6; t++) {
                int nextFloor = currentFloor + df[t];
                int nextRow = currentRow + dr[t];
                int nextColumn = currentColumn + dc[t];
                if(nextFloor>=0&&nextRow>=0&&nextColumn>=0&&nextFloor<floor&&nextRow<row&&nextColumn<column) {
                    if(tomato[nextFloor][nextRow][nextColumn]==0) {
                        queue.add(new int[]{nextFloor, nextRow, nextColumn});
                        tomato[nextFloor][nextRow][nextColumn] = tomato[currentFloor][currentRow][currentColumn] + 1;
                        days = tomato[nextFloor][nextRow][nextColumn] - 1;
                        ripe++;
                    }
                }
            }
            if(ripe==total) break;
        }

        if(ripe<total) System.out.println(-1);
        else System.out.println(days);
    }
}