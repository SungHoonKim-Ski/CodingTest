import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[][] dp;
    static final int MOD = 10_007;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void pro() {
        dp = new long[n + 1][n + 1];
        for (int j = 0; j <= n; j++)
            Arrays.fill(dp[j], -1);

        System.out.println(recur(1, 0));
    }

    static long recur(int h, int d) {
        if (d < 0 || d > h - 1) return 0;
        if (h >= 2 && d == 0) return 0;

        if (h == n) return 1;

        if (dp[h][d] != -1) return dp[h][d];

        long sum = 0;
        if (d == 0) {
            sum = 2L * recur(h + 1, 1);
        } else {
            sum += 2L * recur(h + 1, d);
            sum += recur(h + 1, d + 1);
            sum += recur(h + 1, d - 1);
        }

        return dp[h][d] = sum % MOD;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}