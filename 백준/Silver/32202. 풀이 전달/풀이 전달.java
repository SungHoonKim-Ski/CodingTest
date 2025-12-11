import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, cnt;
    static final int MOD = 1_000_000_007;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];

        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 1));
    }

    static int recur(int cur, int prev) {
        if (cur == n) {
            return 1;
        }

        if (dp[cur][prev] != -1) return dp[cur][prev];

        int sum = 0;
        if (prev == 0) {
            sum += recur(cur + 1, 1);
            sum %= MOD;
            sum += recur(cur + 1, 1);
        } else {
            sum += recur(cur + 1, 0);
            sum %= MOD;
            sum += recur(cur + 1, 1);
            sum %= MOD;
            sum += recur(cur + 1, 1);
        }

        return dp[cur][prev] = sum % MOD;
    }
}