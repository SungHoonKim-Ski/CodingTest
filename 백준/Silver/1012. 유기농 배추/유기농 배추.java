import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br;
    static StringBuffer sb;
    public static int[][] cabbageFarm;
    public static boolean[][] isChecked;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        cabbageFarm = new int[51][51];
        isChecked = new boolean[51][51];

        int cases = Integer.parseInt(br.readLine());
        for(int i=0; i<cases; i++){
            getCabbage();
        }
        System.out.println(sb);
    }

    static int farmY;
    static int farmX;
    public static void getCabbage() throws IOException{

        String[] input = br.readLine().split(" ");
        farmY = Integer.parseInt(input[0]);
        farmX = Integer.parseInt(input[1]);
        int cabbageCount = Integer.parseInt(input[2]);
        initArr();
        bugCount = 0;

        for (int j = 0; j < cabbageCount; j++) {
            input = br.readLine().split(" ");
            int tmpY = Integer.parseInt(input[0]);
            int tmpX = Integer.parseInt(input[1]);
            cabbageFarm[tmpY][tmpX] = 1;
        }
        for(int i=0; i<farmY; i++){
            for(int j=0; j<farmX; j++){
                BFS(i, j, false);
            }
        }

        sb.append(bugCount).append('\n');
    }

    static int bugCount;

    public static void BFS(int y, int x, boolean isCalled){
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        if(isChecked[y][x]) return;
        isChecked[y][x] = true;
        if(cabbageFarm[y][x] == 1){
            if(!isCalled) bugCount++;
            for(int i=0; i<4; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if(nextX < 0 || nextX == farmX || nextY < 0 || nextY == farmY) continue;
                if(cabbageFarm[nextY][nextX] == 1){
                    BFS(nextY, nextX, true);
                }
            }
        }
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