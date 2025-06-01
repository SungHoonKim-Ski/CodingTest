import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] nums;
    static int[][] prefixSum, dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + nums[j];
            }
        }
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) Arrays.fill(dp[i], -1);
    }

    static void pro() {
        System.out.println(recur(1, n));
    }

    static int recur(int i, int j) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int x = i; x < j; x++) {
            dp[i][j] = Math.min(recur(i, x) + recur(x + 1, j) + prefixSum[i][j], dp[i][j]);
        }

        return dp[i][j];
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();
            pro();
        }
    }
}