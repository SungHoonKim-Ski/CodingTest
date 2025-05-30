import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static char[][] map;
    static int[][][][] dp;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dp = new int[n][n][2][k + 1];
        for (int[][][] d1 : dp)
            for (int[][] d2 : d1)
                for (int[] d3 : d2)
                    Arrays.fill(d3, -1);
    }

    static int recur(int y, int x, int dir, int change) {
        if (y == n - 1 && x == n - 1) return 1;
        if (dp[y][x][dir][change] != -1) return dp[y][x][dir][change];

        dp[y][x][dir][change] = 0;

        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if (ny < n && nx < n && map[ny][nx] != 'H') {
            dp[y][x][dir][change] += recur(ny, nx, dir, change);
        }

        
        if (change > 0) {
            int nextDir = (dir + 1) % 2;
            ny = y + dy[nextDir];
            nx = x + dx[nextDir];
            if (ny < n && nx < n && map[ny][nx] != 'H') {
                dp[y][x][dir][change] += recur(ny, nx, nextDir, change - 1);
            }
        }

        return dp[y][x][dir][change];
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();
            int result = 0;
            if (map[0][1] != 'H') result += recur(0, 1, 0, k);
            if (map[1][0] != 'H') result += recur(1, 0, 1, k);
            System.out.println(result);
        }
    }
}
