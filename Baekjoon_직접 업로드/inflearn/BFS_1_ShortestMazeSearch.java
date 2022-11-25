import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.;

class Main{

    static int maxMove = Integer.MAX_VALUE;
    static int[][] mazeArr = new int[7][7];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void DFS(int x, int y, int move){
        if(x == y && y == 6){
            maxMove = Math.min(move, maxMove);
            return;
        }
        for(int i=0; i4; i++){
            int tmpX = x + dx[i];
            int tmpY  = y + dy[i];
            if(tmpY  -1 && tmpY  7 && tmpX  -1 && tmpX  7 && mazeArr[tmpY][tmpX] == 0){
                mazeArr[y][x] = 1;
                DFS(tmpX, tmpY, move + 1);
                mazeArr[y][x] = 0;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i7; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j7; j++){
                mazeArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, 0);
        if(maxMove == Integer.MAX_VALUE)
            maxMove = -1;
        System.out.println(maxMove);
    }
}