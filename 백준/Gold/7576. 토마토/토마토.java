import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int zeroCount = 0;
        int[][] tomato = new int[y][x];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<y; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<x; j++){
                int tmp = Integer.parseInt(input[j]);
                if(tmp == 0){
                    zeroCount++;
                }else if(tmp == 1){
                    queue.add(new int[]{i, j});
                }
                tomato[i][j] = tmp;
            }
        }

        int dayCount = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (zeroCount > 0){
            Queue<int[]> nextDayQueue = new LinkedList<>();
            boolean isChanged = false;
            while (!queue.isEmpty()){
                int[] freshTomato = queue.poll();
                int curY = freshTomato[0];
                int curX = freshTomato[1];

                for(int i=0; i<4; i++){
                    int tmpY = curY + dy[i];
                    int tmpX = curX + dx[i];

                    if(tmpX < 0 || tmpY < 0 | tmpX == x || tmpY == y) continue;

                    if(tomato[tmpY][tmpX] == 0){
                        tomato[tmpY][tmpX]++;
                        zeroCount--;
                        isChanged = true;
                        nextDayQueue.add(new int[]{tmpY, tmpX});
                    }
                }
            }
            if(!isChanged){
                dayCount = -1;
                break;
            }
            queue.addAll(nextDayQueue);
            dayCount++;
        }

        System.out.println(dayCount);
    }

}