import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, s, m;
    static int[][] dp;
    static int[] nums;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro()  {
        long[][] dp = new long[n + 1][20 + 1];

        dp[1][nums[1]] = 1;
        for (int i = 2; i < n; i++) {
            int cur = nums[i];
            for (int j = 0; j <= 20; j++) {
                if (j - cur >= 0) dp[i][j] += dp[i - 1][j - cur];
                if (j + cur <= 20) dp[i][j] += dp[i - 1][j + cur];
            }
        }

        System.out.println(dp[n - 1][nums[n]]);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}