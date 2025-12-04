import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][][] dp;
    static int[] dx = {0, 1, 0, -1, 1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1};
    static int[] start = {20, 20};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        dp = new int[50][50][20];
        for (int i = 0; i < 50; i++)
            for (int j = 0; j < 50; j++) Arrays.fill(dp[i][j], -1);

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dfs(start[0], start[1], n));
        }
    }

    static int dfs(int x, int y, int move) {
        if (move == 0) {
            if (x == start[0] && y == start[1]) {
                return 1;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (dp[x][y][move] != -1) return dp[x][y][move];

        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            cnt += dfs(nx, ny, move - 1);
        }

        return dp[x][y][move] = cnt;
    }
}