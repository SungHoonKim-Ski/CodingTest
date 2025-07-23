import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, cnt;
    static int[][][][] dp;

    static final int MOD = 1_000_000_007;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        dp = new int[n][2][3][3];
    }

    public static void pro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        System.out.println(recur(1, 0, 0, 0));
    }

    static int recur(int idx, int two, int prev1, int prev2) {
        if (idx == n) {
            if (two == 0) return 0;
            return 1;
        }

        if (idx > n) return 0;

        if (dp[idx][two][prev1][prev2] != -1) return dp[idx][two][prev1][prev2];

        dp[idx][two][prev1][prev2] = 0;

        dp[idx][two][prev1][prev2] += recur(idx + 1, two, 0, prev1);
        dp[idx][two][prev1][prev2] %= MOD;

        if (prev1 == 0) {
            dp[idx][two][prev1][prev2] += recur(idx + 1, two, 1, prev1);
            dp[idx][two][prev1][prev2] %= MOD;

            dp[idx][two][prev1][prev2] += recur(idx + 1, 1, 2, prev1);
            dp[idx][two][prev1][prev2] %= MOD;
        } else if (prev1 == 1) {
            if (prev2 == 0) {
                dp[idx][two][prev1][prev2] += recur(idx + 1, two, 1, prev1);
                dp[idx][two][prev1][prev2] %= MOD;

                dp[idx][two][prev1][prev2] += recur(idx + 1, 1, 2, prev1);
                dp[idx][two][prev1][prev2] %= MOD;
            }
        } else { // prev1 == 2
            if (prev2 == 0) {
                dp[idx][two][prev1][prev2] += recur(idx + 1, two, 1, prev1);
                dp[idx][two][prev1][prev2] %= MOD;
            }
        }

        return dp[idx][two][prev1][prev2];
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}