import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] island;
    static boolean[][] checkedIsland;
    static int islandCount = 0;
    static int n;
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        island = new int[n][n];
        checkedIsland = new boolean[n][n];
        StringTokenizer st;

        for(int j = 0; j<n; j++){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                island[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j = 0; j<n; j++){
            for(int i=0; i<n; i++){
                BFS(j, i, false);
            }
        }
        System.out.println(islandCount);
    }

    public static void BFS(int y, int x, boolean isCalled){
        if(checkedIsland[y][x]) return;
        checkedIsland[y][x] = true;
        if(island[y][x] == 1){
            if(!isCalled) islandCount++;
            for(int i=0; i<8; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if(nextX < 0 || nextX == n || nextY < 0 || nextY == n) continue;
                if(island[nextY][nextX] == 1){
                    BFS(nextY, nextX, true);
                }
            }
        }
    }
}