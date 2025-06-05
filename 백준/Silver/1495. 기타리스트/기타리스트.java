import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, s, m;
    static int[][] dp;
    static int[] volumes;
    static int maxSum = -1;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        volumes = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro()  {
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) Arrays.fill(dp[i], -1);
        dp[s][0] = 1;

        for (int i = m; i >= 0; i--) {
            if (recur(i, n) == 1) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    static int recur(int volume, int idx) {
        if (volume < 0 || volume > m) return 0;
        if (idx < 0) return 0;
        if (dp[volume][idx] != -1) return dp[volume][idx];

        dp[volume][idx] = 0;
        if (recur(volume + volumes[idx], idx - 1) == 1
                || recur(volume - volumes[idx], idx - 1) == 1) {
            dp[volume][idx] = 1;
        }
        return dp[volume][idx];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}