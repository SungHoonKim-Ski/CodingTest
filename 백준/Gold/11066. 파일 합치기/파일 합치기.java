import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] files;
    static int[][] prefixSum;
    static int[][] dp;


    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        files = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum = new int[n + 1][n + 1];
        prefixSum[1][1] = files[1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + files[j];
            }
        }
    }

    public static void pro() {
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][i] = 0;
        }

        System.out.println(recur(1, n));
    }

    static int recur(int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int x = i; x < j; x++) {
            dp[i][j] = Math.min(dp[i][j], prefixSum[i][j] + recur(i, x) + recur(x + 1, j));
        }

        return dp[i][j];
    }

    public static void main(String[] args) throws Exception{
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();
            pro();
        }
    }
}