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
        int z = Integer.parseInt(input[2]);

        int zeroCount = 0;
        int[][][] tomato = new int[z][y][x];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<z; i++){
            for(int j=0; j<y; j++){
                input = br.readLine().split(" ");
                for(int k=0; k<x; k++){
                    int tmp = Integer.parseInt(input[k]);
                    if(tmp == 0){
                        zeroCount++;
                    }else if(tmp == 1){
                        queue.add(new int[]{i, j, k});
                    }
                    tomato[i][j][k] = tmp;
                }
            }
        }

        int dayCount = 0;
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (zeroCount > 0){
            Queue<int[]> nextDayQueue = new LinkedList<>();
            boolean isChanged = false;
            while (!queue.isEmpty()){
                int[] freshTomato = queue.poll();
                int curZ = freshTomato[0];
                int curY = freshTomato[1];
                int curX = freshTomato[2];

                for(int i=0; i<6; i++){
                    int tmpZ = curZ + dz[i];
                    int tmpY = curY + dy[i];
                    int tmpX = curX + dx[i];

                    if(tmpZ < 0 || tmpZ == z || tmpX < 0 || tmpY < 0 || tmpX == x || tmpY == y) continue;

                    if(tomato[tmpZ][tmpY][tmpX] == 0){
                        tomato[tmpZ][tmpY][tmpX]++;
                        zeroCount--;
                        isChanged = true;
                        nextDayQueue.add(new int[]{tmpZ, tmpY, tmpX});
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