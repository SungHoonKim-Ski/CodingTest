import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static int[][] tomatoArr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int dayCount = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        tomatoArr = new int[y][x];

        Queue<int[]> tomatoQueue = new LinkedList<>();
        int zeroCount = 0;
        for(int i=0; i<y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++){
                tomatoArr[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoArr[i][j] == 0){
                    zeroCount++;
                }else if(tomatoArr[i][j] == 1){
                    tomatoQueue.add(new int[] {i, j});
                }
            }
        }

        while (zeroCount > 0){
            Queue<int[]> nextDayQueue = new LinkedList<>();
            while (!tomatoQueue.isEmpty()){
                int[] tmpArr = tomatoQueue.poll();
                int tmpY = tmpArr[0];
                int tmpX = tmpArr[1];
                for(int i=0; i<4; i++){
                    int nextY = tmpY + dy[i];
                    int nextX = tmpX + dx[i];
                    if(nextX < 0 || nextY < 0 | nextX == x || nextY == y) continue;
                    if(tomatoArr[nextY][nextX] == 0){
                        nextDayQueue.add(new int[]{nextY, nextX});
                        tomatoArr[nextY][nextX] = 1;
                        zeroCount--;
                    }
                }
            }
            if(nextDayQueue.isEmpty()){
                dayCount = -1;
                break;
            }
            tomatoQueue = nextDayQueue;
            dayCount++;
        }
        System.out.println(dayCount);
    }
}