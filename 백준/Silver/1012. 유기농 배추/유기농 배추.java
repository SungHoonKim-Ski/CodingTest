import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br;
    public static int[][] cabbageFarm;
    public static boolean[][] isChecked;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int farmCount = Integer.parseInt(br.readLine());

        cabbageFarm = new int[51][51];
        isChecked = new boolean[51][51];

        for(int i=0; i<farmCount; i++) {
            sb.append(getCabbage()).append('\n');
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static int y;
    static int x;

    public static int getCabbage() throws IOException{

        String[] input = br.readLine().split(" ");
        y = Integer.parseInt(input[0]);
        x = Integer.parseInt(input[1]);
        int cabbageCount = Integer.parseInt(input[2]);

        initArr();


        for (int j = 0; j < cabbageCount; j++) {
            input = br.readLine().split(" ");
            int tmpY = Integer.parseInt(input[0]);
            int tmpX = Integer.parseInt(input[1]);
            cabbageFarm[tmpY][tmpX] = 1;
        }

        int insectCount = 0;

        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                insectCount += calBug(i, j);
            }
        }

        return insectCount;
    }

    public static int calBug(int curY, int curX){


        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int returnVal = 0;
        if(cabbageFarm[curY][curX] == 1) {
            cabbageFarm[curY][curX] = 0;
            if(!isChecked[curY][curX]){
                isChecked[curY][curX] = true;
                returnVal = 1;
            }
            for(int k=0; k<4; k++){
                int tmpY = curY + dy[k];
                int tmpX = curX + dx[k];
                if(tmpX < 0 || tmpY < 0 | tmpX == x || tmpY == y) continue;
                isChecked[tmpY][tmpX] = true;
                calBug(tmpY, tmpX);
            }
        }
        return returnVal;
    }

    public static void initArr(){
        for(int i=0; i<51; i++){
            for(int j=0; j<51; j++){
                isChecked[i][j] = false;
                cabbageFarm[i][j] = 0;
            }
        }
    }
}
