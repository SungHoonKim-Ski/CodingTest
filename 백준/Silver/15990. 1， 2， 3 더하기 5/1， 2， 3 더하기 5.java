import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, MAX_VALUE = 100_000, MOD = 1_000_000_009;
    static int[][] dp;

    static void init() {
        dp = new int[MAX_VALUE + 1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= MAX_VALUE; i++) {
            dp[i][1] = dp[i - 1][2] + dp[i - 1][3];
            dp[i][1] %= MOD;
            dp[i][2] = dp[i - 2][3] + dp[i - 2][1];
            dp[i][2] %= MOD;
            dp[i][3] = dp[i - 3][2] + dp[i - 3][1];
            dp[i][3] %= MOD;
        }
    }

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
    }

    public static void pro() throws IOException {
        int sum = (dp[n][1] + dp[n][2]) % MOD;
        sum += dp[n][3];
        sum %= MOD;

        System.out.println(sum);
    }


    public static void main(String[] args) throws Exception{
        init();
        int tc = Integer.parseInt(br.readLine());
        while (tc -- > 0) {
            input();
            pro();
        }
    }
}