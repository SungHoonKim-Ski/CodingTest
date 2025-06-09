import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int TEN_BIT = 1 << 10, MAX = 100, MOD = 1_000_000_000;
    static int[][][] dp;

    static int recur(int depth, int curNum, int visit) {
        if (dp[depth][curNum][visit] != -1) return dp[depth][curNum][visit];

        if (depth == 1) {
            return visit == (TEN_BIT - 1) ? 1 : 0;
        }

        int sum = 0;
        if (curNum != 0) {
            sum += recur(depth - 1, curNum - 1, visit | (1 << (curNum - 1)));
            sum %= MOD;
        }

        if (curNum != 9) {
            sum += recur(depth - 1, curNum + 1, visit | (1 << (curNum + 1)));
            sum %= MOD;
        }

        return dp[depth][curNum][visit] = sum;
    }

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
    }

    public static void pro() {
        dp = new int[n + 1][10][TEN_BIT];
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 10; j++)
                Arrays.fill(dp[i][j], -1);

        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += recur(n, i, 1 << i);
            sum %= MOD;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}