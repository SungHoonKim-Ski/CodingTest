import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] dx = {0, 1}, dy = {1, 0};
    static int[][] map;
    static long[][] dp;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void pro() {
        dp = new long[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0, 1));
    }

    static long recur(int x, int y, long count) {
        if (x == n - 1 && y == n - 1) {
            return count;
        }

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        
        if (map[x][y] == 0) return 0;
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * map[x][y];
            int ny = y + dy[i] * map[x][y];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            dp[x][y] += recur(nx, ny, count);
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}