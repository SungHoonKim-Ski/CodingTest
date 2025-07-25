import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int MAX = 1_000;

    static int n, m;
    static int[][] map;
    static int[][] dp;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j] - '0';
            }
        }
    }

    public static void pro() {
        dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, recur(i, j));
            }
        }

        System.out.println(max * max);
    }

    static int recur(int x, int y) {
        if (x >= n || y >= m) return 0;

        if (dp[x][y] != -1) return dp[x][y];
        if (map[x][y] == 0) return dp[x][y] = 0;

        dp[x][y] = recur(x + 1, y + 1);
        dp[x][y] = Math.min(dp[x][y], recur(x + 1, y));
        dp[x][y] = Math.min(dp[x][y], recur(x, y + 1));

        return ++dp[x][y];
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}